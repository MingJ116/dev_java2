package ch1.week6;

import java.net.ServerSocket;
import java.net.Socket;

/*단일 상속만 되니, 인터페이스 지원
 * 인터페이스를 통해 스레드 구현방법*/

public class ChatServer implements Runnable {
//	메인스레드이다
	
	
	public static void main (String[] args) {
		System.out.println ("main시작");
		ChatServer cs = new ChatServer ();
		Thread th = new Thread (cs);
		th.start ();
		System.out.println ("main끝");
	}
	
	@Override
	public void run () {
		System.out.println ("run 호출 성공");
		int port = 3000;
		ServerSocket ss = null;
		
		try {
			ss = new ServerSocket (port);
			/*대기상태로 대기, 시간이 가다 ChatClient에서 new Socket("서버IP", 3000)*/
			System.out.println ("서버소켓 생성 완료 - 클라이언트 소켓 접속 대기중");
			while (true) {
				/*아래 코드가 진행되는 시점은 ? - new Socket("192.168.10.96,3000") */
				Socket client = ss.accept ();
				System.out.println ("클라이언트측 : " + client.getInetAddress ()); // 접속한 클라이언트 정보 출력
//			    대기 상태 풀림
				/* 금융권에서 주로 사용 = 보안강화 = 직렬화기법 - 마샬링, 언마샬링 구간
				(마샬링 = 메모리 상에 형상화된 객체 데이터를 적당한 다른 데이터 형태로 변환하는 과정.
				  전송된 데이터를 다시 원래의 객체 모양으로 복원하는 작업은 언마샬링(Unmarshalling)
				* 말하기 - ObjectOutputStream -> writeObject(); 네트워크 전송 발생 -> 패킷
				* 듣기  - ObjectInputStream -> readObject(); */
			}
		} catch (Exception e) {
			e.printStackTrace ();
		}
	}
}
