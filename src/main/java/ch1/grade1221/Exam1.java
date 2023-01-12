package ch1.grade1221;
//코드 중 에러가 나는 코드 라인을 모두 찾아 [원인](10점)에 작성하고, 에러가 나는 이유를 [조치내용](10점)에 상세히 작성하시오. (20점)
public class Exam1 {
	public void test(byte i){}
	public void test(String str, double o){}
	public void test(int i, short l){}
	public void test(String s){}
	public void test(char ch){}
	public void test(String str, int i){}
	public void test(int i, String str){}
	public void test(int i){}
	public int test(){return 0;}
}






/*자바에서는 같은 이름의 메소드를 중복 선언 가능하다
 * 메소드 오버로딩(Method Overloading)
 * 메소드 오버라이딩(Method Overriding)
 * 무조건 파라미터의 갯수나 타입이 달라야 한다
 * 접근제한자가 있고 없고는 영향이 없으며 리턴 타입도 마찬가지다
 * 예외를 던지고 던지지 않고는 영향이 없다
 * 파라미터의 변수이름이 다른것은 영향이 없다
 * 메소드 오버라이딩(Method Overriding) - 문제와 상관없음
 * */
