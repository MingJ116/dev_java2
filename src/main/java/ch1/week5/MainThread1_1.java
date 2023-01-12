package ch1.week5;

/*
 * main메소드 호출은 JVM에 의해 호출된다.
 * JVM은 main스레드를 생성하여 main메소드를 호출한 것이다.
 * 따라서 프로그램을 실행할 때 main메소드가 실행되었다는 것은 main스레드가
 * 수행되는 것이다.
 * 그리고 main안에서 사용자가 만든 새로운 스레드를 실행시켰다면
 * 두 개의 스레드(main 스레드와 사용자 스레드)가 작동하고 있다는 것을 의미한다.
 * 아래 결과는 예측 불허(실행할 때마다 다를 수 있다.)
 *
 */
public class MainThread1_1 {// 나는 스레드 클래스가 아님
	/*단, 메인스레드는 갖고있음
	 * 18-19-20(main start) ->21(인스턴스화=아직run호출안됨)->25(implements라 필요, 상속이면 필요X)
	 * -> Dec29(start()->run():즉시 실행않고 대기실에서 순서따짐) so, yield나 join) -> 50->51->64->69->*/
	
		public static void main (String[] args) {
		System.out.println ("====================================");
		System.out.println ("main start");
		Runnable r = new MyRunnableOne (); // 인터페이스 = 구현체 클래스(override:run -> 추상메소드 MyrunnableOne이 구현해냄)
//		코드를 조금만 수정(1달전 코딩-오타)하고 유지보수가 가능함.
//		많이 손대면 손댈수록 의존관계로 인해 다른 에러를 유발 시킴.
		Thread myThread = new Thread (r);
//		Thread myThread = new Thread(this); // this를 쓴다면? => 여기서는 MainThread1_1이다 그렇다면 난 스레드가 아니다.
//		1. 스레드가 아니라 에러
//		2. static안에서는  this를 사용불가. Runnable을 implements하지도 않았기에 this를 쓰면 망한다.
		myThread.start (); /*디폴트 가중치는 5이다. */
		try { 
			myThread.yield (); /* .yield 하면 양보 .join 하면 양보안하고 나 먼저 처리 <- 이러한 메소드를 Thread 클래스가 제공
			양보, 고집, 순서대로 Scheduling 하기 위해서 이런 스레드를 구현한다.*/
			
		} catch (Exception e) {
		}
//		Thread himThread = new MyRunnableTwo (); //나 자신이 스레드 일때 .start(); 호출하는 방법과 아닐때의 방법을 기억. 이것이 runnable
//		himThread.start (); // 상속이니까 가능, 디폴트 가중치는 5이다 그러나 절대적이진 않다.
		/*상속처리, 인페로 처리하던간에, 그에 따른 가중치는 없고 공평하다.
		 * 누구든 먼저 선점하는 스레드가 우선권을 갖는다.*/
		System.out.println ("main end");
	}
}
/*      Thread가 되는 방법 2가지
		1.상속
		2.implements
		공통점 => 둘다 run메소드를 가질수 있다.(재정의 가능) -> 그 안에서 실행문을 처리하면 안전.
 */
class MyRunnableTwo extends Thread {
	@Override
	public void run () {
		System.out.println ("MyRunnableTwo 호출 성공");
	}
}

class MyRunnableOne implements Runnable {
	@Override // 이 자리에는 스레드가 와야한다, 그러나 스레드를 상속받거나 runnable을 implements하면 된다
	public void run () {
		System.out.println ("run메소드 호출 성공");
		first ();
	}
	
	public void first () {
		System.out.println ("first메소드 호출 성공");
		second ();
	}
	
	public void second () {
		System.out.println ("second메소드 호출 성공");
		System.out.println ("====================================");
	}
}

/*클래스를 상속받으면, 클래스간에 결합도가 높아진다 -> 재사용성 ↓(오작동 경험)
 * 기능적인 부분의 결합도를 낮추며, 테스트도 용이하며, 오작동도 방지되는 방법
 * :인터페이스 중심 코딩을 전개하는 방법 */