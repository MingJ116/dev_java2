package ch1.Practice;

import java.util.Scanner;

public class Total {
	
	int array[] = new int[5];
	void setArray(){
		Scanner s = new Scanner (System.in);
		for(int i=0;i<array.length;i++){
			System.out.print("정수를 입력하세요");
			array[i] = s.nextInt ();
		}
		s.close ();
		arrayPrint ();
	}
	void arrayPrint(){
		for(int i:array){
			System.out.println (i);
		}
	}
	
	int total () {
		int tot = 0;
		for (int i = 0; i < 5; i++) {
			tot = tot + array[i];
			System.out.println (tot);
		}
		return tot;
	}
	
	int average () {
		int avg = 0;
		for (int i = 0; i < 5; i++) {
			avg = avg + i;
			System.out.println (avg);
		}
		return avg / 5;
	}
	
	public static void main (String[] args) {
		Total a = new Total ();
		a.setArray ();
		a.total ();
		a.average ();
		int result = a.total ();
		double result2 = a.average ();
		System.out.println ("정수의 합은" + result);
		System.out.println ("정수의 평균은" + result2);
		
		
	}
}
