package ch1.vector;

import java.util.Vector;

public class Vector6 {
	String[] header = {"부서번호", "부서명", "지역"};
	String[][] datas = {{"10","20","30"}, {"개발부","인사부","총무부"}, {"서울","인천","부산"}};
	
	public static void main (String[] args) {
		String[][] depts = {
				{"10", "아비부", "서울", "02-1234-1235"},
				{"20", "피카부", "충청", "031-1597-1414"},
				{"30", "말리부", "경상", "032-4987-2535"}
		};
		Vector<String[]> vdepts = new Vector<>();
		for (int i = 0; i < depts.length; i++) {
			vdepts.add(depts[i]);
			
		}
		for(int i =0; i < vdepts.size(); i++){
			String[] oneRow = vdepts.get(i);
			for(int j =0; j < oneRow.length; j++){
				System.out.println(oneRow[j]+ " ");
				
			} // end of inner for
			System.out.println();
		} //end of outter for
		
	} // end of Main
} // end of Vector6
