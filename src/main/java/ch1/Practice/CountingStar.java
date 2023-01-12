package ch1.Practice;

import java.util.Scanner;

public class CountingStar {
	public static void main (String[] args) {
		
		Scanner s = new Scanner (System.in);
		System.out.println("출력하고 싶은 삼각형의 크기");
		int size = s.nextInt (); // 정수형 타입 int, 변수명을 size라 하고, 스
		int i, j;
		for (i = 1; i <= size; i++) {
			for (j = 3; j <= i; j++) {
                System.out.print("*");
			}
			System.out.println();
            }
		}
	}

