package daoex;

import java.util.ArrayList;

import daoex.dao.DeptDAO;
import daoex.entity.Dept;

public class DAOEx1 {
	public static void main(String[] args) {
		DeptDAO dao = new DeptDAO();
		ArrayList<Dept> list = dao.getAll();
		
		for(Dept d:list) {
			System.out.println("부서아이디: " + d.getDeptId());
			System.out.println("부서명: " + d.getDeptName());
			System.out.println("지역아이디: " + d.getLocID());
			System.out.println("-----------------------------");
		}
		
	}
}
