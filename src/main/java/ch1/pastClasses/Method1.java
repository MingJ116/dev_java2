package ch1.pastClasses;

public class Method1 {
  /*
   * 파라미터 자리에는 비워두거나 원시형을 쓰거나 참조형도 올수 있다.
   * 파라미터 자리는 호출하는곳에서 결정된다
   * 파라미터 자리 변수는 언제 초기화가 되나 ? = 메소드가 호출될때 결정 됨
   * 메소드 호출은 어디서 ?? = main 메소드 안에서 해야 호출 된다.
   * 메소드의 파라미터 자리는 호출될때 복사되고 오직 선언만 가능 = 초기화는 불가하다 - 불법이다
   * 증명해봐
   * 값에 의한 호출이다
   */
  void m(int i) {// 파라미터 자리에는 사용자가 입력한 값이 담김 // 5가 복사됨
    i = i + 2;
    i = (i*0) + 10;
    // i = 5;
  
    System.out.println(i);
  }

  void m(){ // 이렇게 되면 합법이 됨 

  }
  double m1(double d) {
    return 3.5;
  }////// end of m1

  public static void main(String[] args) {
    // Method1 클래스안에 정의된 메소드만 호출이 가능함.
    Method1 method1 = new Method1();
    int i = 1;
    //자바에서는 같은 이름의 메소드를 중복선언 할수있음.
    // 단 파라미터의 갯수가 다르거나, 타입이 다르면 인정 - 관련검색어 Method Overloading
    method1.m(i); // Method호출, 파라미터 안에 정수를 작성해야함
      }////// end of main
}
