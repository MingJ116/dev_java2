package ch1.week6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class S1 {
	int age = 30;
		
}


class S2 {
	String animal = "사자";
	int leg = 4;
	
}


class S3 {
//3개짜리 클래스 설계


}

public class MapTest1 {
	List<Map<String, Object>> list = null; //선언
	
	
	
	public static void main (String[] args) {
		S1 s1 = new S1();
		Map<String, Object> map1 = new HashMap<> ();
		map1.put("s1", s1);
		S1 s2 = (S1)map1.get("s1");
		System.out.println (s2.age);
		Map<String, Object> map11 = new HashMap<> ();
//		map11.put("s1", s1);
		
	
		Map<String, Object> map2 = new HashMap<> ();
		S2 s3 = new S2();
		map2.put("s2", s3);
		S2 s4 = (S2)map2.get("s2");
	    if(s4.animal instanceof String) {
	    	System.out.println("문자열이다");
		    System.out.println (s4.animal);
	    }
		if(new Integer (s4.leg) instanceof Integer) { // 줄이 간 Integer는 Deprecated 되었다. 하지만 에러는 아니다. 지원을 안할수도 있는 메소드 이니 가급적이면 사용을 피할것.
			System.out.println("정수형이다");
			System.out.println (s4.leg);
		}
	
	}
}
