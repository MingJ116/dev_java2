package ch1.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 회원정보 담기
public class MapTest3 {
	
	public static void main (String[] args) {
		List<Map<String, Object>> list = new ArrayList<> ();
		System.out.println (list); //
		Map<String, Object> pMap = new HashMap<> ();
		pMap.put ("mem_id", "tomato");
		pMap.put ("mem_name", "토마토");
		pMap.put ("mem_pw", "123");
		pMap.put ("mem_gender", "M");
		list.add (pMap);
		System.out.println (list); //
		
		/*List<Map<>> = 밖에 있는 List는 대괄호
		* 제네릭은 {}, 중괄호
		* list 이용*/
		System.out.println ("1 : "+list.get (0)); //
		System.out.println ("2 : "+list.get (0).get("mem_name")); //
		System.out.println ("3 : "+list.get (0).get("mem_pw")); //
//		System.out.println (pMap);
		System.out.println (pMap.toString ());
//		System.out.println (pMap.get ("mem_name"));
		
	}
}


	/*회원 ID,이름,비번,성별
	mem_id, mem_name, mem_pw, mem_gender
	tomato, 토마토, 123, 남자
	banana, 바나나, 234, 여자
	Grape, 포도, 345, 여자*/















	/*for (int i = 0; i < list.size(); i++) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(String.valueOf(i), i+"value");
		
		list.add(map);
	}
		System.out.println ("List :" + list.toString ());
		System.out.println ("");
	
	}
}
*/