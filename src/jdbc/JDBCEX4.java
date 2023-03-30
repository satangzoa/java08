package jdbc;

import java.sql.*;

public class JDBCEX4 {
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
		String sql = "delete from dept "+
					 "where dept_id = 60";
		
		//DB에 연결을 시도
		Connection con = DriverManager.getConnection(url, "c##user1", "1234");

		
		System.out.println("오라클 DB에 연결되었습니다!!!");

		Statement stmt = con.createStatement();
		int num = stmt.executeUpdate(sql);
				
		System.out.println(num + "행이 적용되었습니다.");
		
		con.close();
	}
}





