package ch1.design;

public class Quack implements QuackBehavior{
	
	@Override
	public void quack() {
		System.out.println("<<꽥~꽥~~~~>>");
	}
	
}