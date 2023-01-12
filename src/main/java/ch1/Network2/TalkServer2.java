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
// POJO F/W설계 - 인페중신코딩전개수업 - Spring Boot(전자정부프레임워크)기반 MVC패턴수업 진행
// JS 수업(ES5,6,7소개) - NodeJS
//리액트수업 (객체,클래스,React Hook, 메소드, 파라미터, 리턴타입

public class TalkServer2 extends JFrame implements /*Runnable,*/ ActionListener {
	// 선언부
	//클라이언트측에서 new Socket하면 그 소켓정보를 받아서 쓰레드로 넘김
	TalkServerThread2 tst = null;
	//동시에 여러명이 접속하니까 List - Vector<>(); 멀티스레드 안전, 속도  느림
	List<TalkServerThread2> globalList = null;
	ServerSocket server = null;
	Socket socket = null;
	JTextArea jta_log = new JTextArea (10, 30);
	JScrollPane jsp_log = new JScrollPane (jta_log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JButton jbtn_log = new JButton ("로그저장");
	
	// 생성자
	public TalkServer2 () { // 생성자 = 클래스 이름이 다르면 생성자 이름도 변경해야함
		//initDisplay();//시점문제- 스케쥴링
	}
//	스레드가 2개이므로 화면 요청과 start() 순서를 바꾸더라도 각자 처리가 됨
	public static void main (String[] args) {
		TalkServer2 ts = new TalkServer2 ();
		ts.init(); // 나는 about Server, 대기중, (사용자,클라,고객,업무담당자를 기다림)
		ts.initDisplay ();
//		내 안에 run메소드가 재정의(오버라이드)되어있으니까
//		아래의 코드가 에러발생하는것은 Runnable를 implements에서 제거하였기 때문.
//		Thread th = new Thread (ts); // 스레드 생성시 파라미터로 Talkserver 객체를 넘김
////		스레드 풀(Pool)에 있는 스레드중, 우선순위를 따지고 차례대로 입장.(ready 상태 )
//		th.start ();//52번 호출됨 - 지연발생함 - 클라이언트가 접속할때까지 기다림...
	
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
	public void init () { // Override로 인해서 형식을 바꿀수없다 // 오버라이드가 성립되려면 인페가 구현 되어야하는데 지웠으니 쓸수가없음.
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
			while (!isStop) { // 언제 while 문으로 진입하지 ? -> new - ? 멈춤 -> New socket(IP서버의 port
				socket = server.accept ();
				jta_log.append ("client info:" + socket + "\n");
				jta_log.append ("client info:" + socket.getInetAddress () + "\n");
//              String - VARCHAR2, CHAR, int - number(5):9999  double - number(7,2) 99999.99
//				이종간의 언어에서 데이터를 공유(static)목적으로 설계하는 디자인 패턴명 -DTO(Data Transfer Object)
//				DeptVO - this 사용 - 전변초기화 => ValueObject 패턴의 일부 - 오라클과 자바연동에 필요한 목적으로 설계됨.
//				이벤트 처리시 이벤트 처리를 담당하는 클래스를 가리키는 목적으로 this를 사용.
//				ActionListener를 구현 할 때 - 버튼.addActionListener (this);
//				new XXX(this); - 클래스 분리 할 때, 나눌때, MVC패턴으로 구현 할 때
//				생성자 호출시 파라미터로 들어오는 this는 현재(now, 살아있는) 인스턴스화된 객체를 가리킴
//				여기서 this 는 Talkserver임.
//				아래는 객체를 생성하는 것과 동시에 생성자를 호출하는데 클래스 이름을 바꾸어서 에러가 발생
//				해결법은 TalkServerThread의 생성자 파라미터 타입을 TalkServer2로 변경.
				TalkServerThread2 tst = new TalkServerThread2 (this); // TalkServer2
//				TalkServer가 화면을 만들때 JFrame을 상속 받았다. 그래서 부모를 나타낼땐 super, 나를 나타낼땐 this
//				TalkServerThread tst = new TalkServerThread (super); // 여기서 super는 JFrame이다
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