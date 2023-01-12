package ch1.exam;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class NetTest {
	
	public void output(){
		FileWriter fw = null;
		try {
			fw = new FileWriter ("test.txt");
			fw.write (97);
//			fw.write (65);
			fw.close ();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace ();
		}catch (IOException e) {
			e.printStackTrace ();
		}
		}
	
	public static void main (String[] args) {
		NetTest nt = new NetTest ();
		nt.output ();
	}
		
		
		
		
//			fw = new FileWriter("c:\\temp\\test.txt");
//			fw.write("Hello World");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				fw.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
	}

