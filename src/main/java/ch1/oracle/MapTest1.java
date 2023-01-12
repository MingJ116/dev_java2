package ch1.oracle;

import java.util.*;

public class MapTest1 {
	Map<String,Object> rMap = new HashMap<> ();
	public void setMap(){
		rMap.put("deptno", 10);
		rMap.put("dname", "인사부");
		rMap.put("loc", "서울");
//		rMap.put("loc", "부산");
		
	}
	public static void main (String[] args) {
		MapTest1 mt1 = new MapTest1();
		mt1.setMap();
		System.out.println (mt1.rMap.size ()); // 0->3
//		Map에서 제공하는 메소드중 key값을 묶음 처리하는 메소드가 있음.
		Set<String> set = mt1.rMap.keySet ();
//		Set인터페이스가 제공하는 메소드중 toArray()메소드를 지원.
		Object obj[] = set.toArray (); // deptno dname loc가 담김.
		for(int i =0; i<obj.length; i++) { // 여기서 length는 배열 원소의 갯수 = 3개 (deptno, dname, loc)
			String key = (String) obj[i]; // 배열에서 꺼낸 값은 key값이다 => deptno dname loc
			System.out.println ("key:" + key); // 고로 3번 출력
		}
		System.out.println ("==============================================");
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) { // 자료구조 내부에 값이 있는지 체크, 있다면 true 없으면 false
			String key = iter.next ();
//		String value = (String)mt1.rMap.get(key);
			Object value = mt1.rMap.get(key);
			System.out.println (key+ ":"+value);
			
		}
	}
}
