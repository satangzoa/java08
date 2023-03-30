package jdbc;

import java.sql.*;

public class JDBCEx1 {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클드라이버를 로드하였습니당.");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클드라이버를 읽어올 수 없습니다.(로드불가)");
		}
				
	}
	
	public static void main(String[] args) throws SQLException {
		// DB연결에 필요한 정보를 하나의 문자열로 구성(약속된 형식으로 작성)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		//DB에 연결을 시도
		Connection con = DriverManager.getConnection(url, "c##user1", "1234");
		
		System.out.println("오라클 DB에 연결되었습니다!!!");

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT dept_id, dept_name, loc_id FROM dept");
		
		while(rs.next()) {
			System.out.println("부서코드: " + rs.getString("dept_id"));
			System.out.println("부서명: " + rs.getString( "dept_name"));
			System.out.println("지역번호: " + rs.getString(3));
			System.out.println("----------------------------");
		}
		
		rs.close();
		con.close();
	}
}





