package ch1.Practice;

public class Method {
	int Method(int a){
		a++;
		return a;
	}
	
	public static void main (String[] args) {
		int a = 1;
		Method mtd = new Method ();
		a = mtd.Method(a);
		System.out.println(a);
		
	}
}
