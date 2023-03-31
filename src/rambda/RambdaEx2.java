package rambda;

public class RambdaEx2 {
	public static void main(String[] args) {
		// 1. 인터페이스를 구현한 클래스를 임시로 생성
		// 2. 미완성의 매서드를 작성한 코드로 완성
		// 3. 임시 클래스로 객체를 생성하고 위치값 반환
//		MyInterface m1 = new xxx();
		MyInterface m1 = (n1, n2) ->  n1 * n2; //미완성의 매서드를 여기서 재정의한다
		MyInterface m2 = (n1, n2) ->  n1 + n2;
		
		System.out.println("10 * 20 = " + m1.operate(10,20));
		System.out.println("10 + 20 = " + m2.operate(10,20));
	}
}

interface MyInterface {
	int operate(int v1, int v2);
}

