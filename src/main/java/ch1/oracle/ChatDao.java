package ch1.oracle;

/*클래스 설계에 있어서 DAO 패턴의 사용은 필수
 * 특히 MYBATIS같은 ORM 솔루션이 제공 되며 더 강조.
 * JDBC API -> MYBATIS(GOOGLE):30%줄어듦 -> JPA(HIBERNATE) - 클래스 설계
 * 쿼리문이 없다.(추상적, JOIN관계는 어쩜?
 * */


import ch1.util.DBConnectionMgr;

import java.sql.CallableStatement;
import java.sql.Connection;

public class ChatDao {
	Connection con = null; // 인터페이스 - 비벼지는 부분, 연계, 연동
	CallableStatement cstmt = null;
	DBConnectionMgr dbMgr = new DBConnectionMgr();
	
	public String login(String mem_id, String mem_pw) {
		String mem_name = null; // 네가 원하는 이름을 지정
		try {
			con = dbMgr.getConnection(); // 물리적으로 떨어져 있는 오라클 서버와 연결 통로 확보
			cstmt = con.prepareCall("{call proc_login(?,?,?)}");
			cstmt.setString(1, mem_id);
			cstmt.setString(2, mem_pw);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.execute();
			mem_name = cstmt.getString(3);
			System.out.println ("mem_name:"+mem_name);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return mem_name; // 회원가입했던 네 이름 
	}
	
	public static void main (String[] args) {
		ChatDao cDao = new ChatDao();
		String r_name = cDao.login("kiwi", "tiger");
		System.out.println(r_name);
	}
	
}
