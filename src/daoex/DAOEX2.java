package daoex;

import java.util.ArrayList;

import daoex.dao.DeptDAO;
import daoex.entity.Dept;

public class DAOEX2 {
	public static void main(String[] args) {
		ArrayList<Dept> list = DeptDAO.getInstatnce().getAll(); //메소드를 호출한다
		Dept dept =  DeptDAO.getInstatnce().get(30);
		
		
	}
}
