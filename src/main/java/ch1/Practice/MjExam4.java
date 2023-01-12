package ch1.Practice;

import java.util.Scanner;

public class MjExam4 {
	int cnt = 0;
	
	public void method(String start, String end) {
		int istart = Integer.parseInt(start);
		int iend = Integer.parseInt(end);
		for (int a = istart; a < iend; a++) {
			if (a % 3 == 0) {
				System.out.println(a + " : 는 3의 배수입니다.");
				cnt++;
			} // else if (a % 3 != 0) {
			// System.out.println(a + " : 3의 배수가 아닙니다.");
			// }
		}
	}
	
	public static void main(String[] args) {
		MjExam4 m = new MjExam4();
		Scanner s = new Scanner(System.in);
		String start = null;
		System.out.println("시작숫자 입력하세요");
		start = s.nextLine();
		System.out.println("마지막숫자 입력하세요");
		String end = null;
		end = s.nextLine();
		m.method(start, end);
		System.out.println(m.cnt);
	}
}
