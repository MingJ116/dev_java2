package ch1.vector;

import java.util.Vector;

public class Vector4 {
	public static void main (String[] args) {
		
		String fruits[] = {"키위","포도","사과"}; // 키위 다음에 토마토를 추가해라
		Vector<String> vfruit = new Vector<> ();
		for(int i = 0; i<fruits.length; i++){
			vfruit.add(fruits[i]);
		}
		System.out.println(vfruit.size ());
		vfruit.add(1,"토마토");
		for(int i = 0; i < vfruit.size(); i++) {
			if (vfruit.get (i).equals ("포도")) ;
			vfruit.remove (i);
		}
		
//		if(fruits.contains("포도");{
//			vfruit.remove("포도");
		
//			System.out.println (vfruit.get (i));
		}
//		vfruit.remove (1); // 이렇게 하면 포도를 지우라는 요청에 대한 상수 방식
	}

