package daoex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import daoex.entity.Dept;

public class DeptDAO implements DAO<Dept> {//T를 대신할 타입이Dept
	//싱글톤 패턴을 만들어서 외부에서 객체를 생성하지 못하게 만든다
	//1. private 생성자를 추가(외부에서 객체 생성 불가)
	private DeptDAO() { }
	
	//2. 하나의 객체를 참조할 참조변수 추가(static)
	private static DeptDAO dao;
	
	//3. 객체를 만들어주는 메서드를 추가
	public static DeptDAO getInstatnce() {
		if (dao == null)
			dao = new DeptDAO();
		
		return dao;
	}
	
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클드라이버를 읽어올 수 없습니다.(로드불가)");
		}
	}

	@Override//잠와 ㅠㅠ
	public Dept get(int id) {
		String sql = "select dept_id, dept_name, loc_id from dept where dept_id = ?";
		ResultSet rs = null;
		Dept dept = null;
		
		Connection con = getConnection();
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			//결과집합 내 행의 개수가 1개이기 때문에 반복문 사용하지 않음 if사용함 
			if(rs.next()) {
				//DB에서 받은 밥, 반찬, 국을 임시로 저장
				int deptId = rs.getInt("dept_id");
				String deptName = rs.getString("dept_name");
				int locId = rs.getInt("loc_id");
				
				// 도시락 통을 만들고 임시로 저장한 음식을 담음
				 dept = new Dept(deptId, deptName, locId);
				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	finally {
				try {
					if (rs != null)
						rs.close();// 닫는 작업도 예외사항이 발생할 수 있음
					if (con != null)
						con.close();
				} catch (SQLException e) {}
				
		}
		return dept; //도시락을 반환
	}

	@Override
	public ArrayList<Dept> getAll() {
		String sql = "select dept_id, dept_name, loc_id from dept order by dept_id";
		ResultSet rs = null;
		//도시락 통을 담기 위한 박스를 생성
		ArrayList<Dept> list = new ArrayList<Dept>();
		
		Connection con = getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			 rs = stmt.executeQuery();
			
			while(rs.next()) {
				//DB에서 받은 밥, 반찬, 국을 임시로 저장
				int deptId = rs.getInt("dept_id");
				String deptName = rs.getString("dept_name");
				int locId = rs.getInt("loc_id");
				
				// 도시락 통을 만들고 임시로 저장한 음식을 담음
				Dept dept = new Dept(deptId, deptName, locId);
				
				//포장한 도시락통을 박스에 담음
				list.add(dept);
				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	finally {
				try {
					if (rs != null)
						rs.close();// 닫는 작업도 예외사항이 발생할 수 있음
					if (con != null)
						con.close();
				} catch (SQLException e) {}
				
		}
		return list; //박스를 반환
	}

	@Override
	public int insert(Dept item) {
		int num = 0; //적용된 행의 개수
		Connection con = null;

		String sql = "insert into dept(dept_id, dept_name, loc_id) " +
					 "values(?, ?, ?)";
		
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, item.getDeptId());
			stmt.setString(2, item.getDeptName());
			stmt.setInt(3, item.getLocID());
		
			num = stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("[오류]" + e.getMessage());
		}	finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) { }
		}
		
		return num;
	}

	@Override
	public int update(Dept item) {
		int num = 0; //적용된 행의 개수
		Connection con = null;

		String sql = "update dept set dept_name = ?,  loc_id = ? where dept_id = ?";
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, item.getDeptName());
			stmt.setInt(2, item.getLocID());
			stmt.setInt(3, item.getDeptId());
			num = stmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("[오류]" + e.getMessage());
		}	finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) { }
		}
		
		return num;
	}

	@Override
	public int delete(int id) {
		int num = 0; //적용된 행의 개수
		Connection con = null;

		String sql = "delete from dept where dept_id = ?";
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, id);
			num = stmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("[오류]" + e.getMessage());
		}	finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) { }
		}
		
		return num;
	}

}
