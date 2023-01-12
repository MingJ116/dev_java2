package ch1.Network2;

import javax.swing.*;

public class KiwiServer extends JFrame implements Runnable{
//=======================================선언부==============================






//=======================================생성자===============================
	public KiwiServer(){
		System.out.println ("KiwiServer디폴트 생성자 호출");
	
	}
	
//	=================화면출력===============
	public void initDisplay () {
		this.setTitle ("키위톡");
		this.setSize (400,300);
		this.setVisible (true);
		
	}
//=======================================메인메소드===========================
public static void main (String[] args) {
	KiwiServer ks = new KiwiServer ();
	ks.initDisplay ();
	Thread th = new Thread (ks); // 스레드 생성시 파라미터로 Talkserver 객체를 넘김
	th.start ();
	}
	
	public void run(){
		System.out.println ("Run호출 성공");
//		경합이 벌어지는 일
//		지연(대기)이 필요한일
		/*일반 메소드로 처리 할 때와 다른 점.
		*1. 보장받는다. 늦게라도 실행됨 - 일반 메소드는 어플리케이션이 종료되면 보장 못함. 다시는 호출 안됨
		*2. 개별적 동작을 할 수 있다 */
	}
}
