package ch1.week6;

import java.net.InetAddress;
import java.net.Socket;

public class ChatClient {
	
	public void client () {
		int port = 3000;
		String serverIP = "192.168.10.84"; // 현재 내 ip 작성함
		/* java.net, java.io 인터넷 회선 장애문제 발생
		 * io 생성시 소켓을 통해 인스턴스화를 하니 상호 의존관계 성립.
		 * 이런 패키지는 반드시 예외처리 할것 (Thread - 인터셉트를 당할 수 있기에.)
		 * Object마다 lock flag 값이 있어, 스레드가 점유하면 잠김- 다른스레드 사용불가
		 * Deadlock 상태에 빠질 수 있다. (Deadlock = 내부에서 잠김으로 다른 스레드가 사용불가)
		 * 한정된 자원을 여러 사람이 이용하기 위해 제공되는 클래스 => Thread
		 * Thread.sleep();, */
		
		try {
			System.out.println (InetAddress.getLocalHost().getHostAddress ()); // 내 서버 아이피를 출력
			Socket socket = new Socket (serverIP, port); // 서버에 접속
		} catch (Exception e) {
			/*에러메세지에 대한 history를 기억, 라인번호와 함꼐 이력을 출력.
			디버깅시에 꼭 필요함*/
			e.printStackTrace ();
		}
		
	}
	public static void main (String[] args) {
		ChatClient cc = new ChatClient();
		cc.client();
	}
}
