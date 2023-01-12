package ch1.vector;

import java.util.Vector;

public class Vector5 {
	public static void main (String[] args) {
		
		//		과일가게의 진열된 상품
		String fruits[] = {"키위", "포도", "사과", "토마토", "메론", "파인애플", "바나나", "복숭아"};
		
		//		내가 좋아하는 과일명
		String myFruits[] = {"키위", "사과", "바나나", "용과", "스타프룻"};
		//		이 과일중 본인이 좋아하는 과일만 골라서 Vector에 담아주세요
		//		insert here
		Vector<String> vfruit = new Vector<> ();
		
		for (int i = 0; i < fruits.length; i++) {
			for (int j = 0; j < myFruits.length; j++) {
				if (fruits[i].equals (myFruits[j])) {
					vfruit.add (fruits[i]);
				}
			}
		} // end of for
		//구매한 과일을 출력하라
		System.out.println ("내가 좋아하는 과일은 ");
		for(String f : vfruit){
			System.out.print (f + " ");
			
		}
	} // end of Main
}
		
		
		
		
		/*Vector<String> vfruits1 = new Vector<> ();
		for (int i = 0; i < fruits.length; i++) {
			vfruits1.add (fruits[i]);
		}
		System.out.println (vfruits1.size ());
//		vfruits1.add (6, "용과"); // set과 다른점은 기존 인덱스 위치에 새로 추가하여 기존 인덱스를 뒤로 밀어냄.
		vfruits1.set (2,"용과"); // add와 다른점은 기존 인덱스 위치를 대치함.
		for (int i = 0; i < vfruits1.size (); i++) {
			System.out.println (vfruits1.get (i));
		}
	}
}*/
