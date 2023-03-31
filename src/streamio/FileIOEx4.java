package streamio;

import java.io.*;

public class FileIOEx4 {
	public static void main(String[] args) throws IOException {
		FileWriter fw  = new FileWriter("MyText.txt");
		PrintWriter out = new PrintWriter(fw);
		
		
		out.println("안뇽안뇽??");
		out.println("쉬었다 하자요.");
		out.println("좋은 하룽.");
		out.println("잘 써져야하는디.");
		
		out.close();
		
		FileReader fr = new FileReader("MyText.txt");
		BufferedReader br = new BufferedReader(fr);//fr 위치값을 생성자를 통해 전달한다
		
		String line;
		
		int lineNo = 0;
		
		while((line = br.readLine()) != null) {
			System.out.println(++lineNo + ": " +line);
			
		}
		
		br.close();
		}
}





