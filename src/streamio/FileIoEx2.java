package streamio;

import java.io.*;

public class FileIoEx2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Windows\\explorer.exe");
		FileOutputStream fos = new FileOutputStream("myexplorer.exe");
		
		int len;
		int size = 0;
		byte[] buf = new byte[1024]; //1KB 크기의 버퍼 생성 
		
		while ((len = fis.read(buf)) != -1) {
			fos.write(buf, 0, len); // 버퍼의 처음부터(0번방부터) 읽은 만큼한 쓴다
			size++;
		}
		
		fis.close();
		fos.close();
		
		System.out.println(size + "KB바이트 크기의 파일을 복사하였습니다.");
	}
}







