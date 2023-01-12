package ch1.week4;

import java.util.Vector;

//벡터를 사용해보자
/*Vector는 배열을 제외한, 다른 타입도 담을 수 있다.
 add 메소드를 호출하면, 맨 앞부터 차례대로 담긴다.
 중간에 끼워넣기가 가능. ex) "5번째에 넣어주세요" 가 가능하다 (배열은 고정, 벡터는 변동)

 */
public class A1 {
	
	int ival = 1;
	public static void main(String[] args) {
		A1 a1 = new A1();
		a1.ival = 10;
		System.out.println("8번 주소번지 ==> " + a1);
		Vector<A1> va1 = new Vector<>();
		va1.add(a1);
		a1 = null;// 객체 초기화하면 다음 라인 넘어갈때 캔디데이트 상태가 됨
		a1 = new A1();
		a1.ival = 20;
		System.out.println(a1);
		// insert here
		System.out.println("8번 주소번지 ==> " + va1.get(0));
		A1 a2 = va1.get(0);
		System.out.println("8번 주소번지 ==> " + a2);
		//System.out.println("8번 주소번지 ==> " + a2);
		System.out.println(va1.get(0).ival);
		System.out.println(a1.ival);
		Vector<Integer> v = new Vector<>();
		v.add(1);
		System.out.println(v.get(0));
	}
}
	/*
	public static void main (String[] args) {
		A1 a1 = new A1 ();
		a1.ival = 10;
		System.out.println (a1);
		Vector<A1> va1 = new Vector<A1> (); // <>는 generic 타입 ()는 생성자
		va1.add (a1);
		a1 = null; // 객체초기화하면 다음 라인 넘어갈때 Candidate 상태가 됨. ->
//		 기존에 가르키던 객체와 연결이 끊어지고(재호출 불가능)
//		---------------------------연결고리 끊어짐-----------------------------
		a1 = new A1 (); // new instance로 주소값 재할당
		System.out.println (a1);
		a1.ival = 20;
		System.out.println (a1);
		System.out.println (va1.get (0).ival);
	}
}
*/