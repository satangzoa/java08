package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementEx1 {
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
		
		int deptId = 60;
		String deptName = "퇴근팀";
		int locId = 100;
		
		
		String sql = "insert into dept(dept_id, dept_name, loc_id)" +
						"values(?, ?, ?)";
		
		System.out.println("만들어진 sql: " + sql);
		
		//DB에 연결을 시도
		Connection con = DriverManager.getConnection(url, "c##user1", "1234");
		
		
		System.out.println("오라클 DB에 연결되었습니다!!!");

		PreparedStatement stmt = con.prepareStatement(sql);
		
		// 명령객체 안에 실제로 전송될 값을 설정(? 개수만큼 설정 작업 필요)
		stmt.setInt(1, locId);
		stmt.setString(2, deptName);
		stmt.setInt(3, deptId);
		
		
		int num = stmt.executeUpdate();
				
		System.out.println(num + "행이 적용되었습니다.");
		
		con.close();
	}
}
