package ch1.Practice;

public class MtdOvLd {
	
	static int MtdOvLd (int x, int y) {
		return x * y;
	}
	
	static double MtdOvLd(double x, double y){
		return x + y;
	}
	
	public static void main (String[] args) {
		
		
		int myNum1 = MtdOvLd(8, 5);
		double myNum2 = MtdOvLd(4.3, 6.26);
		System.out.println("int: " + myNum1);
		System.out.println("double: " + myNum2);
	}
}
