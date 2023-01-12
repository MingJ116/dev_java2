package ch1.week4;

import java.util.Vector;

public class Vector21 {
	
	public static void main (String[] args) {
//		2중[outter:=Vector - size(), inner=String[]-length] for문 돌림
//		끼워넣기 가능, 수정에 대한 API제공은 없다 -> 클라우드 기반 데이터베이스 제품이 이런식.
		Vector<String[]> v = new Vector<> (); //		2중 for문 돌렸을때,
		String imsi[] = {"10", "개발부", "서울"};
		v.add (imsi);
		imsi = new String[]{"20", "아비부", "철원"};
		v.add (imsi);
		for (int x = 0; x < v.size (); x++) {//로우의 수
			String[] r = v.get (x);
			for (int y = 0; y < imsi.length; y++) {
				System.out.println (r[y] + "");
				//System.out.println (r[0] + "," + r[1] + "," + r[2]);
			}
			Vector<String> v2 = new Vector<> (); //단일 for문 돌렸을때
		}
	}
}
