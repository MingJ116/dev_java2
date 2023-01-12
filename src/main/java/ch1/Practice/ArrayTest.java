package ch1.Practice;

import java.util.Scanner;

public class ArrayTest {
	
	public static void main (String[] args) {
		int hap=0;
		Scanner s = new Scanner(System.in);
		int[] array = new int[5];
		int i =0;
		for (i = 0; i <= 4; i++) {
			System.out.println("정수를 ");
			array[i] = s.nextInt();
			hap = hap + array[i];
			System.out.print("정수의 합은 " +hap);
			System.out.print("정수의 평균은 " +hap / (double)5);
		}
		
	}
	
	
}
