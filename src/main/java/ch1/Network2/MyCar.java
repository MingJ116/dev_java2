package ch1.Network2;

public abstract class MyCar {
	public abstract void display();
	private int wheelNum = 0 ; // 전역변수이며, 바퀴 수(실제 차의 바퀴수는 4개이니 12번 행이 선택되어야한다.
	
	public MyCar(){
		System.out.println ("MyCar() 호출");
		
	}
	
	public MyCar(int wheelNum){
		System.out.println ("MyCar(int)호출");
		this.wheelNum = wheelNum;
		
	}
	public void go(){
		System.out.println ("가고싶은데로 간다");
	}
}
