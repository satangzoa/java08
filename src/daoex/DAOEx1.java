package daoex;

import java.util.ArrayList;

import daoex.dao.DAO;
import daoex.dao.DeptDAO;
import daoex.entity.Dept;

public class DAOEx1 {
	public static void main(String[] args) {
		DAO<Dept> dao = DeptDAO.getInstatnce();
		ArrayList<Dept> list = dao.getAll();
		
		for(Dept d:list) {
			System.out.println("부서아이디: " + d.getDeptId());
			System.out.println("부서명: " + d.getDeptName());
			System.out.println("지역아이디: " + d.getLocID());
			System.out.println("-----------------------------");
		}
		
		Dept d = dao.get(50);
		
		if (d != null)
		System.out.println("부서id가 " + d.getDeptId()+ "인 부서명: " + d.getDeptName());
		//System.out.println("부서id가 30인 부서명: " + dao.get(30).getDeptName());//dao.get(30)도시락의 위치값//위 두개와 같다
		else
			System.out.println("해당 부서가 존재하지 않습니다.");
		
		//추가할 부서 정보를 전달할 객체를 생성
		Dept d2 = new Dept(70, "놀자팀", 700);
		int num = dao.insert(d2);
		System.out.println(num + "개의 추가 작업이 수행되었습니다." );
		
		//부서 아이디가 50인 부서의 부서명과 지역아이디를 수정
		d.setDeptName("전략기획팀");
		d.setLocID(55);
		num = dao.update(d);
		System.out.println(num + "개의 변경 작업이 수행되었습니다." );
		
		
		//부서id가 70인 부서를 삭제
		num = dao.delete(70);
		System.out.println(num + "개의 삭제 작업이 수행되었습니다." );
		
		
	}
}







