package ch1.vector;

import ch1.deptSeries.DeptVO;

import java.util.Vector;

public class Vector1 {
	public static void main (String[] args) {
		Vector v = new Vector ();
		Vector<String> v2 = new Vector<> (); // <> = 다이아몬드 연산자,
		v2.add ("안녕");
		v2.add ("2");
		Vector<Integer> v3 = new Vector<> (); //
		Vector<DeptVO> v4 = new Vector<> (); // 3차 배열 사용 X
//		v.add (1);
		v.add ("안녕"); //v.get (0)
		v.add ("1"); //v.get (1)
		System.out.println (v.size ()); // 2
		System.out.println (v.get (1)); // 안녕
		String insa = (String) v.get (0); // 강제형전환을 했다
		String insa2 = v2.get (0);
		System.out.println (insa2); // 안녕
		if(v.get (1) instanceof Integer) {
			System.out.println ("넌 정수형");
		}else if(v.get (0) instanceof String){
			System.out.println ("넌 문자열");
		}
	}
}
