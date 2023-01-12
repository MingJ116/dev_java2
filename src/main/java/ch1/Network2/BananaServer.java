package ch1.Network2;

import javax.naming.InitialContext;
import javax.swing.*;

public class BananaServer extends JFrame {
//	생성자
	BananaServer(){
		initDisplay();
	}
	public BananaServer(String title){
		super(title); // f3을 눌러보면 JFrame으로 넘어간다.
		initDisplay();
//		this(title); 자기자신을 호출하는 것이므로 에러
	}
	
	
//	화면그리기
	public void initDisplay () {
		this.setTitle ("버내너");
		this.setSize (400,300);
		this.setVisible (true);
		
	}
	/*this는 클래스 쪼개기 즉, 화면과 로직의 분리 또는 하나의 클래스를 여러개의 클래스로 나누어 처리할 때만 필요
	* this(), this("안녕") <- 이런식으로는 실무에서 사용하지 않는다.*/
	public static void main (String[] args) {
//		생성자 호출하기
//	 new BananaServer ();
//		생성자 파라미터에는 this말고도 다른 타입을 사용가능함. 여기서는 String
	 new BananaServer ("생성자 파라미터로 제목을 결정 -> 초기화");
	
	}


}
/*관전 포인트
* initDisplay를 메인메소드에서 호출하는 것과 생성자 안에서 호출하는것이 가능 하다.
* 그렇다면, 둘의 차이는 있는가? => 차이가 없다.
*
* -작업지시서-
* 키위톡은 메인메소드에서 initDisplay를 호출
* 바나나톡은 생성자에서 initDisplay를 호출
* */