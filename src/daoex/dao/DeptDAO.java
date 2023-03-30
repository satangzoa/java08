package daoex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import daoex.entity.Dept;

public class DeptDAO implements DAO<Dept> {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클드라이버를 읽어올 수 없습니다.(로드불가)");
		}
	}

	@Override
	public Dept get(int id) {
		
		return null;
	}

	@Override
	public ArrayList<Dept> getAll() {
		String sql = "select dept_id, dept_name, loc_id from dept";
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
						rs.close();
					if (con != null)
						con.close();
				} catch (SQLException e) {}
				
		}
		return list; //박스를 반환
	}

	@Override
	public int insert(Dept item) {
		
		return 0;
	}

	@Override
	public int update(Dept item) {
		
		return 0;
	}

	@Override
	public int delete(int id) {
		
		return 0;
	}

}
