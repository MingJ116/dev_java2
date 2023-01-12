package ch1.week4;

import java.util.List;
import java.util.Vector;

public class List2 {
	public static void main (String[] args) {
		/*자료구조를 지원하는 클래스들은 오브젝트의 존재유무 체크
		 * 포함여부
		 * 비어있는지 혹 채워져 있는지 확인할수있는 API를 제공하고있다.*/
		List<String> fruitsList = new Vector<> (); // Multi Thread안전 -> 속도 느림 -> 안전
		fruitsList.add ("버내나");
		fruitsList.add ("어륀지");
		boolean isExist = fruitsList.contains ("버내나");
		isExist = fruitsList.contains ("어륀지");
		if (isExist) {
			System.out.println ("들어있다");
			
		} else {
			System.out.println ("들어있지 않다");
			
		}
//		boolean isEmpty = fruitsList.isEmpty ();
//		System.out.println (isEmpty); // false
//		Vector나 ArraysList는 오브젝트 추가, 꺼내는 기능 제공
//		Iterator는 그 안의 오브젝트가 존재유무를
//		Iterator<String> iter = fruitsList.iterator ();main ();
//			while (iter.hasNext ()) {
//				String fname = iter.next ();
//				System.out.println (fname);
			}
//				Iterator iter2 = fruitsList.iterator ();
//				while (iter2.hasNext ()) { // 다이아몬드 연산자의 의미임 - 타입을 명시적으로 작성함
//					String fname = (String) iter2.next ();
//					System.out.println (fname);
				}
				/*아래와 같이 사용할수 없다
				* bcs, Vector의 Generic Type이 String이라서.*/
//				Iterator <Object> iter3 = fruitsList.iterator ();
//				Iterator <String> iter4 = fruitsList.iterator ();
//				}
			
