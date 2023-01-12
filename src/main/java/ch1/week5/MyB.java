package ch1.week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/*인터페이스는 단독으로 인스턴스화를 할수 없다.
3.오직 추상메소드만 가지고 있다
4.결합도를 낮춰줄수있는 코드로 전개한다*/
public class MyB {
	void m(List<String> myNames){
		System.out.println ("===================[[List<String>]]===================");
		for (String s: myNames){
			System.out.println (s);
		}
	
	}
	void m2(Vector<String> myNames){
		System.out.println ("===================[[Vector<String>]]===================");
		for (String s: myNames){
			System.out.println (s);
		}
	}
/*JVM 에서 제공하는 List에 대해서 구현채 클래스가 여러가지 있다.
* 선언부와 생성부의 타입이 서로 다를 수 있다(권장사항)
* 권장하는 이유는 2가지 선택지가 있다.*/
	public static void main (String[] args) {
		MyB myB = new MyB();
		ArrayList<String> nickNames = new ArrayList<>();
		nickNames.add ("토마토"); // 0
		nickNames.add ("키위"); // 1
		nickNames.add ("사과"); // 2
		
		Vector<String> nickNames2 = new Vector<> ();
		nickNames2.add ("버내너");
		nickNames2.add ("딸기");
		nickNames2.add ("어륀지");
		
		List<String> nickNames3 = new Vector<> ();
		nickNames3.add ("사자");
		nickNames3.add ("호양이");
		nickNames3.add ("표범");
		myB.m(nickNames);
//		myB.m2(nickNames);
		myB.m(nickNames2);
		myB.m2(nickNames2);
//		myB.m2(nickNames3);
		/*왜 nickNames3의 void m2는 안되는가 ? => 범위(scope, List보다 타입이 더 구체적이니까)가 작으니까
		* void m이 void m2보다 받아 줄 수 있는 타입이 더 많고 넓다 = 활용범위가 더 크다. List가 인터페이스라서*/
		myB.m(nickNames3); // void m 이 호출 - 합법
	}
}
