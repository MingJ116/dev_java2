package ch1.Network2;


import ch1.Network1.TalkServerThread;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

//선언과 생성을 분리하는 코딩 전개
//자바는 단일상속만 가능함
//자바는 단일상속의 단점을 보완하기 위해 인터페이스는 다중으로 처리가능함(구현체클래스)
//상속을 받거나 implements하면 부모클래스나, 인터페이스가 정의하고 있는 메소드를 재정의 할수 있다.(Overriding - 선언부는 완전 일치해야함.)
//인터페이스는 오로지 추상메소드만 갖는다.-Runnable도 인터페이스니, 추상메소드가 있다 -> 그것이 run메소드이다.
//class Talkserver extends JFrame, Thread{}
public class TalkServer extends JFrame implements Runnable, ActionListener {
	// 선언부
	//클라이언트측에서 new Socket하면 그 소켓정보를 받아서 쓰레드로 넘김
	TalkServerThread tst = null;
	//동시에 여러명이 접속하니까 List - Vector<>(); 멀티스레드 안전, 속도  느림
	List<TalkServerThread> globalList = null;
	ServerSocket server = null;
	Socket socket = null;
	JTextArea jta_log = new JTextArea (10, 30);
	JScrollPane jsp_log = new JScrollPane (jta_log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JButton jbtn_log = new JButton ("로그저장");
	
	// 생성자
	public TalkServer () {
		//initDisplay();//시점문제- 스케쥴링
	}
//	스레드가 2개이므로 화면 요청과 start() 순서를 바꾸더라도 각자 처리가 됨
	public static void main (String[] args) {
		TalkServer ts = new TalkServer ();
//		내 안에 run메소드가 재정의(오버라이드)되어있으니까
		Thread th = new Thread (ts); // 스레드 생성시 파라미터로 Talkserver 객체를 넘김
//		스레드 풀(Pool)에 있는 스레드중, 우선순위를 따지고 차례대로 입장.(ready 상태 )
		th.start ();//52번 호출됨 - 지연발생함 - 클라이언트가 접속할때까지 기다림...
		ts.initDisplay ();
		
	}
	
	// 화면그리기
	public void initDisplay () {
		jbtn_log.addActionListener (this);
		this.add ("North", jbtn_log);
		this.add ("Center", jsp_log);
		this.setSize (500, 400);
		this.setVisible (true);
	}
	
	// 서버소켓과 클라이언트 소켓을 연결
	@Override
	public void run () { // Override로 인해서 형식을 바꿀수없다
//      서버에 접속해온 클라이언트 스레드 정보를 관리할 벡터 생성하기
//		벡터는 멀티스레드 안전 - 서버에 동식 접속자수가 여러명이라
//		그래서 벡터 안에는 클라이언트를 관리하는 스레드를 추가해야함
//		그 스레드는 메세지를 듣고(청취하고) 들은 내용을 그대로 클라이언트측에 내보냄
//		200#토마토#오늘스터디할까 ? StringTokenizer st = new StringTokenizer("","#");
//		st.nextToken():String - 200
//		st.nextToken():String - 토마토 => 닉네임
//		st.nextToken():String - 오늘스터디할까 ? => 메세지
//
		globalList = new Vector<> ();//멀티스레드안전해서 ArrayList대신 사용함
		boolean isStop = false;
//		try, catch 블록의 네트워크는 항상 장애가 발생 할 수 있다. -> 예외처리함
//		try, catch 사이에는 예외가 발생할 가능성이 있는 코드를 넣는다.
//      CallBack 함수란? => 시스템에서 필요할때 대신 호출해주는 메소드
//		run메소드는 언제 호출 되나요 ? => 스레드 인스턴스변수.start(); 요청하면
//      왜 이리 처리하는가 ? => 여러스레드가 존재하고, 경합이 벌어지므로 우선 순위를 따져가며 호출 함.
//		어떻게 호출 하는가 ?
//		왜 반드시 run메소드를 재정의 해야 할 까?
		try {
			server = new ServerSocket (3000);//서버포트번호 설정하기
			jta_log.append ("Server Ready.........\n");//대기 탐 - 멈춤 - wait
			while (!isStop) { // 언제 while 문으로 진입하지 ? -> new - ? 멈춤 -> New socket(IP서버의 .ㄴport
				socket = server.accept ();
				jta_log.append ("client info:" + socket + "\n");
				jta_log.append ("client info:" + socket.getInetAddress () + "\n");
				TalkServerThread tst = new TalkServerThread (this);
				tst.start ();
			}
		} catch (Exception e) {
			e.printStackTrace ();
		}
	}//////////////////////// [[ end of run ]] /////////////////////////
	
	@Override
	public void actionPerformed (ActionEvent e) {
		//로그를 파일로 저장하기
		
	}
}

/*채팅서버 구축하기
* 클라이언트측에서 접속하면, 접속해온 정보를 서버측 화면에서 볼 수 있다(JFrame을 상속함 -> Log 남김
* 자바는 단일 상속만 가능함 - 이러한 약점을 인터페이스로 지원함 - 그래서 다중인터페이스 구현체는 가능함.
* Thread 구현법
* 1) Thread 상속
* 2) Do implements Runnable interface
* 현재 TalkServer는 JFrame을 상속받고 있어 Runnable을 implements함.*/