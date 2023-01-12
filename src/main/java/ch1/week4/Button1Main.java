package ch1.week4;
//java.lang 패키지가 아닌것은 모두 import를 사용

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Button1 extends JFrame {
	//선언부
	Button1Event bevent = new Button1Event(this); // 상속, 추상클래스, 인터페이스중심의 코딩 전개
//	북쪽배치
	JButton jbtn_ins = null; // 선언만 하였다, 생성자 호출안됨. = 게으른 인스턴스화
	//	남쪽배치
	JButton jbtn_upd = new JButton ("수정"); // 선언 및 생성 동시에 생성자 호출까지 일어남. = 인스턴스화 = 이른 인스턴스화
	
	//생성자
	Button1 () {
		System.out.println ("Button1 디폴트생성자 호출" + jbtn_ins);
		// 생성자 안에서 버튼 객체를 생성하면 뭐가다르지 ? 어떻게 다른걸까 ? -> 시점에 따라 Null Pointer Exception이 발생
		initDisplay (); // new Button1이 호출되면 자동으로 호출이 된다.
		System.out.println ("initDisplay호출 후" + (jbtn_ins == null));
		jbtn_ins = new JButton ("입력"); //
		System.out.println ("입력버튼 생성후 =>" + " " + (jbtn_ins == null));
	}
	
	//화면처리부
	public void initDisplay () {
		jbtn_upd .addActionListener(bevent);
		System.out.println ("호출성공");
//		동쪽배치
		JButton jbtn_del = new JButton ("삭제");
		this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		if (jbtn_ins != null) {
			this.add ("North", jbtn_ins);
		}
		
		this.add ("North", jbtn_ins);
		this.add ("South", jbtn_upd);
		this.add ("East", jbtn_del);
		this.setSize (500, 400);
		this.setVisible (true);
		
	}
}

//ActionListener 의 구현체 클래스이다. => Event Handler Class 이다.
//인터페이스는 추상메소드만 가진다.
class Button1Event implements ActionListener {
//	Button1 button1 = null;
	Button1 button1 = null; // 이걸 주석하면 컴파일 에러(문법오류)
	public Button1Event (Button1 button1) {
		this.button1 = button1;
	}
	
	@Override
	public void actionPerformed (ActionEvent e) {
		Object obj = e.getSource ();
//	수정버튼 눌렀니 ?
		if(obj == button1.jbtn_upd){
			System.out.println ("수정버튼 클릭");
		
		}
	}
}

public class Button1Main {
	
	public static void main (String[] args) {
		Button1 b1 = new Button1 (); // 인스턴스화를 통해 같은 타입의 복제본 3개생성, 각각은 다른 객체
//		Button1 b2 = new Button1 ();
//		Button1 b3 = new Button1 ();
	}
}

