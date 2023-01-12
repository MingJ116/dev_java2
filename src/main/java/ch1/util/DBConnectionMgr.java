package ch1.util;

import java.sql.*;

public class DBConnectionMgr {
	public static final String _DRIVER
			= "oracle.jdbc.driver.OracleDriver"; // 앞 폴더명, 뒤 클래스명
	public static final String _URL
			= "jdbc:oracle:thin:@192.168.110.8:1521:orcl11";
	public static String _USER = "kiwi";
	public static String _PW = "tiger";
	
	public Connection getConnection(){
		Connection con = null;
		try {
			Class.forName (_DRIVER);
			con = DriverManager.getConnection(_URL,_USER,_PW);
		}catch(ClassNotFoundException ce){
			System.out.println ("Cannot found driver class");
		}catch(Exception e){// 멀티 블럭 작성시 더 넓은 클래스가 뒤에 와야함.
			System.out.println ("Failed to connection with OracleServer");
		}
		return con;
	}
//	사용 자원 반납 코드는 명시적으로 하는것을 원칙.
//	반납 순서 = 생성된 역순으로 진행. -자바튜닝팀 지적사항
//	사용 자원 반납하기 - INSERT, UPDATE, DELETE
public void freeConnection(Connection con, Statement stmt){
	if(stmt != null){
		try {
			stmt.close();
		}catch (Exception e){
		
		}
	}
	
	if(con != null){
		try {
			con.close();
		}catch (Exception e){
		
		}
	}
} // end of freeConnection
	public void freeConnection(Connection con, PreparedStatement pstmt){
		if(pstmt != null){
			try {
				pstmt.close();
			}catch (Exception e){
			
			}
		}
		
		if(con != null){
			try {
				con.close();
			}catch (Exception e){
			
			}
		}
	} // end of freeConnection


//  사용 자원 반납하기 - SELECT - 커서조작필요.
	public void freeConnection(Connection con, Statement stmt, ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			}catch (Exception e){
			
			}
			}
		if(stmt != null){
			try {
				stmt.close();
			}catch (Exception e){
			
			}
		}
		if(con != null){
			try {
				con.close();
			}catch (Exception e){
			
			}
		}
	} // end of freeConnection
	public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			}catch (Exception e){
			
			}
			}
		if(pstmt != null){
			try {
				pstmt.close();
			}catch (Exception e){
			
			}
		}
		if(con != null){
			try {
				con.close();
			}catch (Exception e){
			
			}
		}
	} // end of freeConnection

	public static void main (String[] args) {
		DBConnectionMgr dbMgr = new DBConnectionMgr();
		Connection con = dbMgr.getConnection ();
		System.out.println ("con ==>"+con);
	}
}

/*JDBC API이용하여 DB연동하기
* 1. 각 제조사가 제공하는 드라이버 클래스를 로딩한다.(ojdbc6.jar)
* Class.forName(이곳에 드라이버 클래스 기재(풀네임,클래스명까지));
*
* 2. 물리적으로 떨어져 있는 오라클 서버와 연결통로 확보.
* Connection con = DriverManager.getConnection(이곳에 URL,USER,PW);
* Connection은 인터페이스다. -우측에 구현체클래스가 와야 한다.
* Can write method instance? - No
* 3. DML문을 자바에서 오라클 서버로 전달해 줄 인터페이스를 생성한다.(Statement:정적쿼리문, PreparedStatement:동적쿼리문 지원)
*
* 4. SELECT문의 경우 오라클 서버에서 제공하는 커서를 지원하는 ResultSet인터페이스를 활용, 테이블에 제공되는 커서를 조작하여 해당 ROW에 데이터가 존재하면
*    Cursor, Open, Fetch과정을 통해 오라클 서버로부터 데이터를 꺼내, List<DeptVO>에 담을 수 있다.
*
* 주의 : INSERT, UPDATE, DELETE에선 커서가 필요X, 리턴값은 int, 이것들을 요청할때는 executeUpdate(INSERT문 or UPDATE or DELETE문)
*       SELECT 일때는 ResultSet rs = executeQuery("SELECT * FROM dept");
* 오라클에서 제공되는 커서를 조작하는 인터페이스를 리턴 타입으로 제공받아, 조회결과를 collection에 담을수 있다.
* List<DeptVO> deptlist = new ArrayList<>();
* DeptVO dVO = null;
* while(rs.next()){
* dVO = new DeptVO();
*
* deptlist.add(dVO);
* }
*
*
* 사용한 자원 반납시 사용한 역순으로 닫기.
* SELECT의 경우 = ResultSet먼저 닫고 Statement 혹은 PreparedStatement를 닫고 Connection를 제일 나중에 닫기.
* 닫지 않으면 자동으로 언젠가 닫아주기는 하지만 명시적으로 닫으면, 닫는 시간을 앞당길수 있어 플젝에서는 명시적으로 닫는 코드 작성을 가이드로 정함.
*
* INSERT, UPDATE,DELETE는 두번째와 세번째만 닫으면 됨.
* 이유 = 리턴타입이 커서가 필요없어서.
* */