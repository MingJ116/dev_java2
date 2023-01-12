package ch1.week5;

class Sup {
	Sup(){ // 부모클래스 디폴트 생성자
	}
	public void m () {
		System.out.println ("Sup m()호출");
	}
}

class Sub extends Sup {
	Sub(){ // 자손 디폴트 생성자
		this.m (); // super로 하면 부모클래스, this로 하면 자식 클래스
	}
	@Override
	public void m () {
		System.out.println ("Sub m()호출");
	}
	
}

public class SupNSubMain {
	public static void main (String[] args) {
		// insert here 1,2 sup, sub 인스턴스화해서 호출 3번 polymorphism 사용
		Sup sup = new Sup ();
//		sup.m ();
		
		Sub sub = new Sub (); // Sub m ()호출
//		sub.m ();

		Sup sup2 = new Sub (); // 다형성을 사용한 인스턴스 호출
//		sup2.m ();
//		다형성을 위해 선언부에는 (Sup) = 생성부에는 (Sub)이 와야한다
		/*재정의 = 상속된 메소드 내용이 자식 클래스에 맞지 않는경우, 자식 클래스에서 동일한 메소드를 재정의한다.
				  메소드가 오버라이딩 되었다면, 부모객체의 메소드는 숨겨지기에,
				  자식 객체에서 메소드를 호출하면 오버라이딩된 자식 메소드가 호출됨.
				  ================================================================================
				  객체는 상위객체이므로 에러가 발생.
				  그러나 sup2로 하게되면 실제 생성된 객체가 자손인 Sub타입이라,
				  타입이 달라서 강제형전환 해야 하지만, 실제 가리키는 객체가 자손타입이므로 에러 없이 실행 됨.
				  */
		
		sub = (Sub)sup2; // 강제형전환을 통해 sub = new Sup();이 되어버림 그러나 run하면 ClassCastException 오류
		sub.m(); // 이렇게 호출한다면 ?
		int i = (int)23.5d;
		System.out.println (i);
		
	}
	
}
