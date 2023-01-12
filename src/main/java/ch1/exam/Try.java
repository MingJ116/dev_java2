package ch1.exam;

public class Try {
	
	public static void main (String[] args) {
		
		java.util.Scanner sc = new java.util.Scanner (System.in);
		int num1 = 10, num2 = 0;
		
		try {
			
			int num = num1 / num2;
			System.out.println ("입력된 두 정수의 나눗셈 결과값 : " + num);
			
		} catch (ArithmeticException e) {
			System.out.println ("부적절한 나눗셈을 시도하였습니다.");
			System.out.println (e.getMessage ());
			System.out.println ("두 수의 나눗셈 결과 : " + num1 / num2);
		}
		
	}
}
