package ch1.week6;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
	String path ="C:\\Users\\thdau\\eclipse-workspace\\newDev\\src\\main\\java\\ch1\\week6\\test.txt";
	public void output() {
		FileWriter fw = null;
		try {
			fw = new FileWriter ("test.txt", true);
			fw.write (95);
			fw.write (47);
			/*IO패키지는 스트림 형태로 이동, 열려있을 경우, 인터셉트, 위변조 가능,
			 * 반드시 사용후에는 close.*/
			fw.close ();
		} catch (FileNotFoundException fe) {
			System.out.println ("파일이 존재하지 않습니다.");
		} catch (IOException ie) {
			ie.printStackTrace ();
		} catch (Exception e) {
			System.out.println (e.getMessage ());
		} finally {
			/*예외가 발생하던 아니던, 무조건 처리할 코드는 여기에 작성.*/
			try {
				if (fw != null) fw.close ();
			} catch (Exception e) {
				System.out.println (e.getMessage ());
			}
		}
	}
	public static void main (String[] args) {
		FileTest ft = new FileTest ();
		ft.output ();
		
	}
}
