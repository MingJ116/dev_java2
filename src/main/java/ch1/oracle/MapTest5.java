package ch1.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 회원정보 담기
public class MapTest5 {
	
	
	public static void main (String[] args) {
		List<Map<String, Object>> fruit = new ArrayList<> ();
		Map<String, Object> rmap = new HashMap<> ();
		rmap.put ("mem_id", "tomato");
		fruit.add(rmap);
		System.out.println ("1 :" + rmap); // 변수명은 같은데 16번은 apple 출력됨
		rmap = new HashMap<> (); // 새로운 객체가 생성 - 타입은 같다.
		rmap.put ("mem_id", "apple");
		fruit.add(rmap);
		System.out.println ("2 :" + rmap); // apple
//		굳이 tomato를 출력하고 싶다면 ?
		System.out.println (fruit.get(0).get("mem_id"));
		System.out.println (fruit.get(1).get("mem_id"));
		
		
		
		
		
	}
	}