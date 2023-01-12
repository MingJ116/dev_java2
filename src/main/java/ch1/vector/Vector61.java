package ch1.vector;

import java.util.Scanner;
import java.util.Vector;

public class Vector61 {
	Vector<String[]> vdepts = new Vector<> ();
	String[][] depts = {
			{"10", "아비부", "서울", "02-1234-1235"},
			{"20", "피카부", "충청", "031-1597-1414"},
			{"30", "말리부", "경상", "032-4987-2535"}
			};
	void initVector () {
		for (int i = 0; i < depts.length; i++) {
			vdepts.add (depts[i]); // 벡터에 담기는 것은 1차 배열 - 컬럼의 수는 바뀔 수 있음. - 4
		}
	}
		void initVectorPrint(){
			for (int i =0; i<vdepts.size(); i++) {
				String[] oneRow = vdepts.get(i);
				System.out.println(oneRow.toString ());
				for (int j = 0; j < oneRow.length; j++){
					System.out.println(oneRow[j]+" ");
				}
			System.out.println("\n");
			}
		} // end of initVectorPrint
	
	public static void main (String[] args) {
		Vector61 v61 = new Vector61 ();
		//initVector 메소드를 경유하지 않았으므로 size는 0이다.
		v61.initVector ();
		//vdepts.get(0) -> {"10","아비부","서울","02-1234-1235"}
		//vdepts.get(1) -> {"10","아비부","서울","02-1234-1235"}
		//vdepts.get(2) -> {"10","아비부","서울","02-1234-1235"}
		
		System.out.println (v61.vdepts.size ()); // 0-> 3
		v61.initVectorPrint ();
		System.out.println ("삭제하고자 하는 부서번호를 입력하세요");
		Scanner s = new Scanner (System.in);
		int deptno = s.nextInt ();
		for (int i = 0; i < v61.vdepts.size (); i++);
		{
			String[] oneRow = v61.vdepts.get(deptno);
			if (deptno == Integer.parseInt (oneRow[0])) {
				v61.vdepts.remove(deptno);
				
			}
		}
			//삭제한뒤 남은 정보 출력해보기 
			System.out.println (v61.vdepts);
			s.close ();
			}
	
		}	
	
