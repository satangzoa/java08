package jdbc;

public class StaticEx1 {
	public static void main(String[] args) throws ClassNotFoundException {
//		OracleDriver d1 = new OracleDriver();
//		OracleDriver d2 = new OracleDriver();
//		OracleDriver d3 = new OracleDriver();
		Class.forName("jdbc.OracleDriver"); 
	}
}

class OracleDriver {
	static {
		System.out.println("오라클 드라이버가 준비되었습니다.");
	}
}
