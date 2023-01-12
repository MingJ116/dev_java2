package ch1.Practice;

public class Baesoo {
	public static void main (String[] args) {
		int sum = 0;
		for(int i=3 ; i<=100 ; i+=3) {
			sum += i;
		}
		System.out.println("1~100까지의 정수 중 3의 배수의 합은 = " + sum);
		
	}
	
}