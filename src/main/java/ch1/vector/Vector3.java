package ch1.vector;

import java.util.Vector;

public class Vector3 {
	public static void main (String[] args) {
		Vector<Integer> v= new Vector<> (); // 객체는 생성되었으나 방은 없다.
		System.out.println(v.size()); // 그러므로 0이다
		System.out.println(v.isEmpty ()); // isEmpty = 비어있는것이냐 ? ,
		
		boolean isExist = v.add(1); // true
		System.out.println(v.get(0));
		System.out.println(isExist); //true
		System.out.println(v.isEmpty ()); //false;
		System.out.println(v.contains (1)); // false -> true
		v.add (1,2);
		System.out.println(v.contains (2));
		System.out.println(v.remove(1));// remove는 삭제된 Object를 보여준다
		//		boolean isOK = v.remove (1); // true
		
	}
}
