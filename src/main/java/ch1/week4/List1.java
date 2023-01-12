package ch1.week4;

import java.util.List;
import java.util.Vector;

public class List1 {
	
	public static void main (String[] args) {
//		아래는 생성부에 인터페이스가 와서 에러. -> 구현체 클래스가 와야함(추상메소드를 Override한 클래스[Vector,Arrays]가 와야함
		List<String> nameList = new Vector<> (); // Multi Thread에 안전 - 속도 느림 - 안전
//		List<String> nameList2 = new ArrayList<> (); // Single Thread 안전 - 속도 빠른 - 안전 하지 못함
		System.out.println (nameList.size ());
		boolean isOk = nameList.add("이순신");
	
	}
}
