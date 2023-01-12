package ch1.Practice;

public class InstanceMethod {
	
	void ismtmt(String x){
		System.out.println(x);
	}
	public static void main (String[] args) {
		InstanceMethod ismt = new InstanceMethod();
		String x = "테스트";
		ismt.ismtmt(x);
	}
}
