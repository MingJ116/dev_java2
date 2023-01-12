package ch1.semiTest;

import java.sql.*;

public class Sql {
	public Connection con = null;
	public Statement stmt = null;
	public ResultSet rs = null;
	
	public Sql() throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con = DriverManager.getConnection("jdbc:odbc:young", "sa", "123456");
		stmt = con.createStatement();
	}
	
	public boolean login(String name, String pw) throws SQLException {
		String strSql ="select * from chat where name ='"+name+"' and password='"+pw+"'";
		ResultSet rs = stmt.executeQuery(strSql);
		boolean login = false;
		while (rs.next()) {
			if (rs.getString("name")!=null
					&& rs.getString("password")!=null) {
				login = true;
				// ClientUi.cs=rs.getInt("class");
			}
		}
		rs.close();
		stmt.close();
		return login;
	}
	
	public void addUser(String name, String pw) throws SQLException {
		String sqlStr = "insert into chat values('" + name + "','" + pw
				+ "')";
		stmt.executeUpdate(sqlStr);
		stmt.close();
		con.close();
	}
	
	
}