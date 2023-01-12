package ch1.week5;

class StopThread implements Runnable {
	boolean stopped = false;
	
	
	@Override
	public void run () {
		while (!stopped) { //true
			System.out.println ("Thread is alive...."); // 출력
			try {
				Thread.sleep (500); // 0.5초후 또 출력 -Thread is alive
			} catch (InterruptedException e) {
				e.printStackTrace ();
			}
		} // end of while
		/*아래코드는 9번과 16번 구간중 12번에서 멈춰 있을때 다른 스레드가 인터셉트 가능함(다른스레드가 있다면)이 안에는 메인스레드가 존재함*/
		System.out.println ("Thread is dead");
	}
	
	public void stop () {
		stopped = true;
	}
}
public class StopThreadTest { 
	/*Dec29(메인스레드) ->31->32(메소드호출)->37->38(객체생성)->39(스레드객체생성 - 파라미터37번주번넘김)
	* 38->8(run콜백)[스레드 대기자 방에서 우선순위를 따진후 우선순위가 높은순서로 - 자기 순서이면 실행시작]
	* */
	public static void main (String[] args) {
		System.out.println ("Main start");
		StopThreadTest stt = new StopThreadTest ();
		stt.process (); // stack영역
		System.out.println ("Main end"); // 어플 죽음 - 메인스레드 회수 - JVM
	}
	
	public void process () {
		StopThread st = new StopThread (); // 지변으로 객체생성 - automatic 이 영역에서만 살고 죽음.
		Thread th = new Thread (st);// 스레드 생성(객체파라미터)
		th.start (); // run 호출
		try {
			Thread.sleep (1000);
		} catch (InterruptedException e) {
			e.printStackTrace ();
		}
		st.stop ();
	}
}						
