package streamio;

import java.io.*;

public class FileIoEx1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Windows\\explorer.exe");
		FileOutputStream fos = new FileOutputStream("myexplorer.exe");
		
		int b;
		int size = 0;
		
		
		while ((b = fis.read()) != -1) {
			fos.write(b);
			size++;
		}
		
		fis.close();
		fos.close();
		
		System.out.println(size + "바이트 크기의 파일을 복사하였습니다.");
	}
}







