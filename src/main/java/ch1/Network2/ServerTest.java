package ch1.Network2;

public class ServerTest {
	
	public static void main (String[] args) {
//      아래 중에서 생성자안에 메소드 호출구문이 있는 쪽은 어디인가?
//		인스턴스화를 하며 생성자(디폴트)도 호출됨.
		BananaServer bs = new BananaServer();
		
//		인스턴스화를 하며 생성자(디폴트)도 호출됨.
		KiwiServer ks = new KiwiServer();
		
	}
}
