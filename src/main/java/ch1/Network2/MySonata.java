package ch1.Network2;

public class MySonata extends MyCar{
	MySonata(){
		System.out.println ("MySonata 호출 완");
	}
	
	@Override
	public void display () { // display는 부모 클래스(MyCar)에 호출되었다.
		System.out.println ("나는 23년형 소나타");
	} //
	
	public static void main (String[] args) {
		
		MySonata ms = new MySonata(); 
	}
}

// 자기 자신의 생성자를 호출하더라도 상속관계에 있는 클래스가 있다면
// 부모 클래스가 먼저 메모리에 올라온다, 하지만 4번처럼