package ch1.week5;

public class PriorityTest extends Thread {
	
	//Field
	private String threadName; //스래드 이름 기억용
	//Constructor
	public PriorityTest(String threadName) { // 생성자
		this.threadName = threadName;
	}
	
	//Method
	@Override
	public void run() {
//스래드 이름 출력 3번 반복
		for(int i = 0; i < 3; i++) {
			System.out.println(threadName + "가 구동됨."); // 얘를 살리면 8,9번을 사용
//			System.out.println(this.getName () + "가 구동됨.");
		}
	}
	
	public static void main(String[] args) {
// 우선 순위 테스트용
		/*나는 Thread를 상속받았다. -> 나의 생성자가 호출되면 그 보다 먼저 Thread생성자 호출됨.
		* 상속관계에 있을때 또는 인페를 implements할때만 Method Override 한다
		* 메소드 오버로딩, 오버라이드는 필수로 외워야함.
		* 쓰레드를 쓰는 이유는 Suspend, join, yield 메서드를 사용하려고 */
		Thread t1 = new PriorityTest("제일 높은 스레드");
		Thread t2 = new PriorityTest("보통 스레드");
		Thread t3 = new PriorityTest("제일 낮은 스레드");
		t1.setPriority(Thread.MAX_PRIORITY); //10 (가중치, 그러나 절대적이지 않다. 먼저일수도 있고, 밀려날수도있다)
		t2.setPriority(Thread.NORM_PRIORITY); //5
		t3.setPriority(Thread.MIN_PRIORITY); //1
		t1.start();
		t2.start();
		t3.start();
	}
}