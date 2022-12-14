package ch1.week6;

import ch1.util.DBConnectionMgr;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ZipCodeSearchView extends JFrame implements ItemListener {
	// 선언부
	// 사용자가 선택한 zdo
	String zdo = null;
	// 사용자가 선택한 sigu
	String sigu = null;
	// 사용자가 선택한 dong
	String dong = null;
	// DB에서 가져온 zdos[]
	String[] zdos = null;
	// DB에서 가져온 sigus[]
	String[] sigus = null;
	// DB에서 가져온 dongs[]
	String[] dongs = null;
	// 중분류(sigu), 소분류(dong)
	String totals[] = { "전체" };
	/*북쪽에 붙일 속지 - 콤보 박스 3개 -JTextField, JButton*/
	
	/*FlowLayout - 배치역할클래스 - 중앙에서 좌,우로 펼치며 배치가 됨*/
//	JPanel jp_north = new JPanel(); // 디폴트 레이아웃 - Flowlayout
	JPanel jp_north = new JPanel(new FlowLayout (FlowLayout.LEFT)); // 디폴트 레이아웃 - Flowlayout
	JComboBox jcb_zdo = null;
	JComboBox jcb_sigu = null;
	JComboBox jcb_dong = null;
	
	
	
	///////////////////////////[[DB 연동 시작]]////////////////////////////////
//	물리적으로 떨어져 있는 오라클 서버에 접속하는데 필요한 공통 코드 작성.
	DBConnectionMgr dbMgr = new DBConnectionMgr(); // Driverclass, 커넥션 정보
	Connection con = null; // 인터페이스
	PreparedStatement pstmt = null; // 인터페이스 - 동적쿼리처리
	ResultSet rs = null;// 오라클 서버의 커서를 조작하는 인터페이스 -next(),previous()
	///////////////////////////[[DB 연동 끝]]////////////////////////////////
	// 동 이름을 입력 받는 텍스트필드와 조회 버튼 추가.
	/*생성자 파라미터 자리를 이용하면 추가적인 메소드 호출 없이도 해당 화면에 대한 추가적인 초기화 작업이 가능하니, 코드의 양을 줄일 수 있다.*/
	
	JTextField jtf_search = new JTextField ("동이름을 입력하세요",20);
	JButton jbtn_search = new JButton ();
	
	
	// 테이블 생성
	String[] cols = { "우편번호", "주소" };
	String[][] data = new String[3][3];
	DefaultTableModel dtm_zipcode = new DefaultTableModel(data, cols);
	JTable jtb_zipcode = new JTable(dtm_zipcode);
	JTableHeader jth_zipcode = jtb_zipcode.getTableHeader();
	JScrollPane jsp_zipcode = new JScrollPane(jtb_zipcode, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	// 생성자
	public ZipCodeSearchView() {
		zdos = getZDOList();
		jcb_zdo = new JComboBox (zdos);
		jcb_zdo.addItemListener(this);
		jcb_sigu = new JComboBox(totals);
		jcb_sigu.addItemListener(this);
		jcb_dong = new JComboBox(totals);
		jcb_dong.addItemListener(this);
	}
	
	// 대분류 정보 초기화에 필요한 DB조회하기 구현
	public String[] getZDOList() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT '전체' zdo FROM dual   ");
		sql.append("UNION ALL                                ");
		sql.append("SELECT zdo                               ");
		sql.append("FROM (                                      ");
		sql.append("		SELECT distinct(zdo) zdo ");
		sql.append("		FROM zipcode_t    ");
		sql.append("		ORDER BY zdo asc)");
		try {
			// con의 주소번지가 확인되면 오라클서버와 연결통로가 확보되었다.
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			// 오라클에서 생성된 테이블의 커서 디폴트위치는 항상 isTop이다.
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<>();
			// rs.previous();
			while (rs.next()) {
				String zdo = rs.getString("zdo");
				v.add(zdo);
			}
			zdos = new String[v.size()];
			v.copyInto(zdos);
		} catch (SQLException se) {
			System.out.println(se.toString());// getMessage()
			System.out.println(sql.toString());
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 사용한 자원 반납하기 - 생성된 역순으로 할것.
			// 생략해도 언제가 반납은 이루어짐 - 명시적으로 반납처리 권장함
			// 왜냐하면 오라클 서버에서 커넥션을 강제로 종료시켜 버리니까.....
			try {
				dbMgr.freeConnection(con, pstmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return zdos;
	}// end of getZDOList
	
	// 화면처리부
	public void initDisplay() {
		jth_zipcode.setBackground(Color.orange);
		jth_zipcode.setFont(new Font("맑은고딕", Font.BOLD, 20));
		jtb_zipcode.getColumnModel().getColumn(0).setPreferredWidth(100);// 간격-우편번호
		jtb_zipcode.getColumnModel().getColumn(1).setPreferredWidth(500);// 간격-주소
		// 그리드 색상 - 빨강
		jtb_zipcode.setGridColor(Color.red);
		// 윈도우창 닫기 버튼 - 자원 회수하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp_north.add(jcb_zdo);
		jp_north.add(jcb_sigu);
		jp_north.add(jcb_dong);
		jp_north.add(jtf_search);
		jp_north.add(jbtn_search);
		this.add("North", jp_north);
		this.add("Center", jsp_zipcode);
		this.setSize(630, 400);
		this.setVisible(true);
	}
	
	// 메인메소드
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		ZipCodeSearchView zcsv = new ZipCodeSearchView();
		zcsv.initDisplay();
	}
	
	@Override
	public void itemStateChanged(ItemEvent ie) {
		// 이벤트가 감지되는 소스가져오기
		Object obj = ie.getSource();
		// 너 ZDO콤보박스니?
		if (obj == jcb_zdo) {
			if (ie.getStateChange() == ItemEvent.SELECTED) {
				System.out.println("선택한 ZDO ===> " + zdos[jcb_zdo.getSelectedIndex()]);
				zdo = zdos[jcb_zdo.getSelectedIndex()];
				sigus = getSiguList(zdo);
				// 대분류가 결정이 되었을 때 sigus를 초기화 해줘야 함
				// 기존에 디폴트로 전체 상수값을 넣어두었으니 이것을 삭제하고
				jcb_sigu.removeAllItems();
				// 새로운 DB서버에서 읽어온 값으로 아이템을 추가해야 한다. - 초기화
				for (int i = 0; i < sigus.length; i++) {
					jcb_sigu.addItem(sigus[i]);
				}
			}
		} // end of jcb_zdo
	}// end of itemStateChanged
	
	public String[] getSiguList(String zdo) {
		// insert here
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT '전체' sigu FROM dual   ");
		sql.append("UNION ALL                                ");
		sql.append("SELECT sigu                               ");
		sql.append("FROM (                                      ");
		sql.append("		SELECT distinct(sigu) sigu ");
		sql.append("		FROM zipcode_t    ");
		sql.append("	 WHERE zdo = ?");
		sql.append("		ORDER BY sigu asc)");
		try {
			// con의 주소번지가 확인되면 오라클서버와 연결통로가 확보되었다.
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, zdo);
			// 오라클에서 생성된 테이블의 커서 디폴트위치는 항상 isTop이다.
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<>();// copyInto메소드 사용위해서
			// rs.previous();
			while (rs.next()) {
				String sigu = rs.getString("sigu");
				v.add(sigu);
			}
			// 시구콤보박스에 들어갈 배열 생성 하기
			sigus = new String[v.size()];
			// 벡터에 들어있는 값 String[]에 복사하기
			v.copyInto(sigus);
		} catch (SQLException se) {
			System.out.println(se.toString());// getMessage()
			System.out.println(sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용한 자원 반납하기 - 생성된 역순으로 할것.
			// 생략해도 언제가 반납은 이루어짐 - 명시적으로 반납처리 권장함
			// 왜냐하면 오라클 서버에서 커넥션을 강제로 종료시켜 버리니까.....
			try {
				dbMgr.freeConnection(con, pstmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sigus;
	}// end of getSiguList
}