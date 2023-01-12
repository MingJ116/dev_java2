package ch1.grade1221;
//제시된 클래스 다이어그램을 분석하여 코드를 작성하였다. 다음 중 잘못된 부분과 이유를 [원인](25점)에 기술하고, 알맞게 고친 코드를 [조치내용](25점)에 완성하여 제출하시오. (단 클래스다이어그램은 수정하지 않음) (50점)
public class Run {
	public static void main (String[] args) {
		Money m = new Money(1);
		m.setMoney (10000);
		m.print();
	}
}
