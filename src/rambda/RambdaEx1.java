package rambda;

import java.util.*;

import daoex.dao.DeptDAO;
import daoex.entity.Dept;

public class RambdaEx1 {
	public static void main(String[] args) {
		ArrayList<Dept> list = DeptDAO.getInstatnce().getAll();
		
//		searchDeptByDeptName(list, "팀");
//		searchDeptByLocId(list, 100);
		
//		searchDept(list, new FilterByDeptName());// new FilterByDeptName()는 객체의 위치값
//		searchDept(list, new FilterByLocId());
		
		//searchDept 매써드가 원하는 객체의 주소를 즉석에서 익명의 객체를(new Filter) 만들고 
		//미완성의 매써드를 완성하여 전달
		searchDept(list, new Filter() { 

			@Override
			public boolean filter(Dept d) {
				return d.getDeptName().contains("전");
			} 
		});
		
//		람다식 적용
		// 익명의 객체를 생성하고 미완성의 매서드를 즉석에서 완성하는 좀 더 쉬운 문법 //d는 파라미터변수 타입은 Dept
		//searchDept(list, (d) -> {return  d.getDeptName().contains("총");}); //익명의 객체를 오버라이딩하면서 미완성의 매써드를 재정의한다
		//람다식을 사용할때는 오버라이딩하는 매서드가(인터페이스에서 매서드가) 반드시 하나 일때만 쓴다
		
		searchDept(list, d -> d.getDeptName().contains("총"));
		searchDept(list, d -> d.getLocID() >= 300);
		
	}
	
	static void searchDeptByDeptName(ArrayList<Dept> list, String key) {
		for(Dept d : list) {
			if (d.getDeptName().contains(key)) {
				System.out.println("부서 id: " + d.getDeptId() + ", 부서명: " + d.getDeptName());
			}
		}
	}
	
	static void searchDeptByLocId(ArrayList<Dept> list, int key) {
		for(Dept d : list) {
			if (d.getLocID() == key) {
				
				System.out.println("부서 id: " + d.getDeptId() + ", 부서명: " + d.getDeptName() + ", 지역 id: "+ d.getLocID());
			}
		}
	}
	
	static void searchDept(ArrayList<Dept> list, Filter filter) { //Filter는 참조변수 filter는 매써드 필터
		for(Dept d : list) {
			if (filter.filter(d)) {
				
				System.out.println("부서 id: " + d.getDeptId() + ", 부서명: " + d.getDeptName() + ", 지역 id: "+ d.getLocID());
			}
		}
	}
	
	
}

// 람다식으로 사용할 수 있는 인터페이스는 반드시 하나의 매서드만 가져야 한다
@FunctionalInterface // 하나의 매서만 갖는 인터페이스임을 표시
interface Filter {
	public boolean filter(Dept d); // 메서드 이름만 만든다
}

class FilterByDeptName implements Filter {
	public boolean filter(Dept d) { //재정의한 매써드 앞에는 public을 붙여줘야한다
		return d.getDeptName().contains("팀");
	}
}

class FilterByLocId implements Filter {
	public boolean filter(Dept d) {
		return d.getLocID() == 100;
	}
}







