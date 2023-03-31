package streamio;

import java.io.*;

public class FileIOEx3 {
	public static void main(String[] args) throws IOException {
		FileWriter fw  = new FileWriter("MyText.txt");
		
		fw.write("안뇽안뇽??\n");
		fw.write("쉬었다 하자요.\n");
		fw.write("좋은 하룽.\n");
		fw.write("잘 써져야하는디.\n");
		
		fw.close();
		
		FileReader fr = new FileReader("MyText.txt");
		
		//읽기용 버퍼를 준비(최대 5000자 글자 크기)
		char[] buf = new char[5000];
		
		// 파일로부터 최대 5000자 글자를 읽어 버퍼에 저장
		int len = fr.read(buf);
		
		// 문자 배열을 문자열로 변환
		String s = new String(buf, 0, len);//0번방부터 실제로 읽은 문자의 갯수를 전해준다
		
		System.out.println(s);
		
		fr.close();
		}
}





