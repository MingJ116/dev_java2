package ch1.week6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest2 {
	
	public static void main (String[] args) {
		List<Map<String, Integer>> list = new ArrayList<> ();
		Map<String, Integer> map1 = new HashMap<> ();
		map1.put("one", 1);
		map1.put("two", 2);
		map1.put("three", 3);
		Map<String, Double> map2 = new HashMap<> ();
		map2.put("one2", (double) 1); // 하지만 얘는 참조형이라 주소번지가 달라서 자동형전환이 이루어지지 않기에 형변환을 해줘야한다.
		map2.put("two2", (double) 2);
		map2.put("three2", 3.0);
		
		int i = 2;
		double d = i; // 원시형이라 상관이 없다
		
		
		
		
		
		
		
		
		
		
	}
}
