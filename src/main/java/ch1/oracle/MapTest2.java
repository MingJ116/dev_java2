package ch1.oracle;

import java.util.*;

public class MapTest2 {
	List<Map<String,Object>> list = new ArrayList<> ();
	Map<String,Object> rMap = new HashMap<> (); // rMap.size() = 0
	public void setMap(){
		rMap.put("deptno", 10);
		rMap.put("dname", "인사부");
		rMap.put("loc", "서울");
		list.add (rMap); // List.get(0) 하면 윗 내용이 나옴
		rMap = new HashMap<> ();// 앞쪽에 타입을 넣으면 중복선언이라서 에러. 단, 전역변수인것은 상관없음
		
		rMap.put("deptno", 20);
		rMap.put("dname", "개발부");
		rMap.put("loc", "부산");
		list.add (rMap);// list.get(1) 하면 윗 내용이 나옴
		rMap = new HashMap<> ();
		
		rMap.put("deptno", 30);
		rMap.put("dname", "총무부");
		rMap.put("loc", "제주");
		list.add (rMap);// list.get(2) 하면 윗 내용이 나옴
	}
	public void mapPrint(){
//		각 row안에 key가 3개있다(컬럼 : deptno dname loc)
//		Map m1 = get(0): 컬럼3개  Map m2 = get(1): 컬럼3개 Map m3 = get(2): 컬럼3개
//		아래에서 반복해야 되는 건 List이다.(ArrayList)
		for (int i = 0; i<list.size (); i++){ // 반복해서 처리할 것은 row값(get(0) get(1) get(2))
			Map<String, Object> m1 = list.get(i);
//			컬럼의 수를 반복출력해야함.
			Object[] keys = m1.keySet ().toArray ();
				for (int j = 0; j < keys.length; j++){
					String key = (String)keys[j];
					System.out.print (m1.get (key)+ "  ");
				}
			System.out.println ();
		}
		}
		
	
	public static void main (String[] args) {
		MapTest2 mt1 = new MapTest2 ();
		mt1.setMap();
//		Map의 size는 세로방향, 컬럼의 수다.
		System.out.println (mt1.rMap.size ()); // 0->3
//		Map에서 제공하는 메소드중 key값을 묶음 처리하는 메소드가 있음.
		Set<String> set = mt1.rMap.keySet ();
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) { // 자료구조 내부에 값이 있는지 체크, 있다면 true 없으면 false
			String key = iter.next ();
//		String value = (String)mt1.rMap.get(key);
			Object value = mt1.rMap.get(key);
			System.out.println (key+ ":"+value);
			
		}
	}
}
