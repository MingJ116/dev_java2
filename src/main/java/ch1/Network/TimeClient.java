package ch1.Network;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TimeClient extends Thread {
	
	Socket socket = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	JLabel jlb_timer = null;
	public TimeClient() {
	}
	
	public TimeClient (JLabel jlb_timer) {
		this.jlb_timer = jlb_timer;
	}
	
	@Override
	public void run() {
		// 서버로 부터 읽어온 시간 정보를 담기
		String timeMsg = null;
		try {
			socket = new Socket("192.168.110.8", 1167);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			while (true) {
				try {
					while ((timeMsg = (String) ois.readObject()) != null) {
						System.out.println(timeMsg);
						jlb_timer.setText(timeMsg);
					} // end of inner while
					sleep(1000);
				} catch (Exception e) {
				
				}
			} // end of outter while
			
		} catch (IOException e) {
			System.out.println("Unavailiable connected to TimeServer.");
		} finally {
			try {
				oos.close();
				ois.close();
				socket.close();
			} catch (Exception e) {
			
			}
		}
		
	}
	
	public static void main(String[] args) {
		// 선언부와 생성부의 이름이 다를 수 있다. - 그래야 다형성 구현이 가능함 - 권장
		// 자바에서는 new 다음에 오는 이름으로 객체가 생성됨
		Thread th = new TimeClient();
		th.start(); // run호출
		
	}
}

/*
 * TimeServer에서 제공하는 현재 시간 정보를 읽어오는 클래스 구현
 * 그런데 스레드를 상속 받은 이유는 1초마다 읽어와야 하니까....
 * sleep(1000)호출해야 함. 그러니까 나는 스레드이어야 함
 * 1초마다 계속 읽어와야 하니까 무한루프 돌린다. - 핸드폰 종료하면
 */

















/*import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TimeClient extends Thread{
	Socket socket = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	public TimeClient(){}
	
	@Override
	public void run() {
	/*서버로 부터 읽어온 시간 정보 담기.*/
		/*String timeMsg = null;
		try { // 아래가 실행되면 TimeServer의 ServerSocket이 accept() 호출하여 클라 소켓 정보를 서버가 취득.
			socket = new Socket ("192.168.10.84", 3210);
			oos = new ObjectOutputStream (socket.getOutputStream ());
			ois = new ObjectInputStream (socket.getInputStream ());
		while (true) {
			try {
				while ((timeMsg = (String)ois.readObject()) !=null){
					System.out.println (timeMsg);
				} // end of inner while
				sleep (1000);
			}catch { (Exception e) {
		
			}
			} // end of outter while
		}catch(Exception e) {
				System.out.println ("Unavailiable connected to TimeServer");
		}finally{
			try {
			oos.close();
			ois.close();
            socket.close();
			}catch (Exception e) {
			}
	}
	*/
	
//	=======================================메인 메소드=======================================
	/*public static void main (String[] args) {
		/*선언부와 생성부의 이름이 다를 수 있다. = 그래야 다형성 구현이 가능함(권장)
		* 자바에서는 new 다음에 오는 이름으로 객체가 생성됨(인스턴스화 개념)
		Thread the = new TimeClient ();
		the.start ();// run 호출
	}*/


/*TimeServer 에서 제공하는 현재 시간 정보를 읽어오는 클래스를 구현.
* Thread를 상속받은 이유는 1초마다 읽어와야 하니, sleep(1000)를 호출해야함. 그러니 Thread여야만 함.
* 1초마다 읽어와야 하니, 무한루프 돌린다. = 꺼지는 유일한 순간은 바로 종료
* */