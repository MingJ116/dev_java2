package ch1.Practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrExam { // 배열 생성후, 숫자 5개를 입력하여 그 수의 합과 평균을 구해라.
	
	public static void main (String[] args) {
		int input = 0;
		Scanner s = new Scanner (System.in);
		int[] Userdata = new int[5];
		int sum = 0;
		double avg = 0;
		
		for (int i = 0; i < Userdata.length; i++) {
			System.out.println ("숫자를 입력하세요" + i + "/" + Userdata.length);
			input = s.nextInt ();
			Userdata[i] = input;
			
		}
		for (int i = 0; i < Userdata.length; i++) {
			sum = sum + Userdata[i];
		}
		avg = sum / Userdata.length;
		System.out.println(Arrays.toString(Userdata));
		System.out.println("합계 = " + sum + "   " + "평균 =" + avg);




	} // end of main
	
} // end of class ArrExam
