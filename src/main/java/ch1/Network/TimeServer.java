package ch1.Network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

// 서버를 기동, 클라이언트가 접속해 오기를 기다린다. - 기다리면 thread
public class TimeServer extends Thread {
	//	=====================================선언부=====================================
	ObjectOutputStream oos = null; // 소켓이 있어야만 객체생성 가능 - 말하기
	ObjectInputStream ois = null; // 소켓이 있어야만 객체생성 가능 - 듣기
	Socket client = null; // 전변위치
//	객체 직렬화가 가능하고, 듣기와 쓰기가 가능한 I/O관련 클래스 선언
//  run 메소드의 재정의 - 스레드에서 해야 할 일을 처리함.
//	반드시 선언부가 일치해야 함.- 부모가 가진 메소드(thread)와
//	TimeServer is a Thread 관계가 성립, 상속처리 가능.
	
	
	//	=====================================생성자=====================================
	TimeServer () {
	}
	
	/*아래 생성자가 필요한 이유는 서버소켓에 접속 해 온 클라이언트 소켓을 Run 메소드에서 사용해야하니 전변으로 치환해야함.*/
	TimeServer (Socket client) {
		this.client = client;
	}
	/* Thread 구현 메소드에서 서버소켓에 접속해온 Client소켓을 가지고 말하기와 듣기에 필요한 OOS와 OIS객체를 생성해야함.
	* I/O도 지연과 Deadlock(죽은상태) 상태에 빠질 수 있으므로 반드시 예외처리 할 것.*/
	@Override
	public void run () {
		try {
			oos = new ObjectOutputStream (client.getOutputStream ());
			ois = new ObjectInputStream (client.getInputStream ());
			while (true) {
				oos.writeObject (getTimeMessage ()); // 12:05:45가 넘어옴
				try {
					sleep (1000);
				} catch (InterruptedException ie) {
				
				}
			}
			} catch(Exception e){
			
		}
		} // end of run
	
	
	
	//	=====================================메인 메소드=====================================
	public static void main (String[] args) {
//		서버소켓 생성시 파라미터로 포트번호가 필요.
		int port = 1167;
//		동시에 여러사람이 접속을 시도.
		ServerSocket server = null;
		Socket client = null; // 여기에 들어오는 소켓은 서버소켓에 접속해온 클라이언트 소켓(주소번지)임.
		try {
			server = new ServerSocket (port);
		} catch (IOException ie) {
			System.out.println ("Can't bind port" + port);
			ie.printStackTrace ();//에러메세지 + 라인번호 함께출력 (힌트문이면서 디버깅)
			try {
				server.close ();
			} catch (Exception e) {
				System.exit (0); // about Server 강제종료
			}
			
		}// end of try,catch
		System.out.println ("Success TimeServer Start");
		
		while (true) {
			try {
//			    클라이언트가 접속해오기를 기다리다 접속(new Socket("192.168.110.8,1167"))을 해오면
//				아래 메소드가 클라이언트 소켓정보를 취득.
				client = server.accept ();
				System.out.println (client.getInetAddress ()); // Client Network info
				System.out.println ("New Client connected");
//              System.out.println (client.getPort());
//			    Thread 개입이 필요 = 1초동안 sleep(1000ms) 호출하고 현재 시,분,초 정보를 출력.
//				Thread 동작 시킴 = Thread의 추상메소드 run을 호출.
//				주의 : run을 직접호출하는게 아니라 start() 호출하면, JVM이 순서 따져 출발시킴(콜백)
				TimeServer ts = new TimeServer (client); // run에서 사용하고싶으니 파라미터 client를 넘김.
				ts.start (); // run() 호출
				System.out.println ("New TimeServer Thread Start");
			} catch (Exception e) {
			
			}
		}
		
	}
	
	public String getTimeMessage () {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		return (hour < 10? "0" + hour : "" + hour)+":"+(min < 10? "0" + min : "" + min)+":"+(sec < 10? "0" +sec : "" + sec);
		//		return "12:05:45";
	}
}

