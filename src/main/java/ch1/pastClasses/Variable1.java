package ch1.pastClasses;

public class Variable1 { // 클래스 안에는 변수가 메소드를 선언 할 수 있다. 그리고 명사형, 동사형이 있다.
  int x;

  // 반환형이 없다.(void라서) 반환형이 없으면 정적변수, 전역변수 사용
  void methodA() {
    // 메소드 선언. 그러나 파라미터가 없는 메소드.
    int i;
    i = 1;
    x = i;
    System.out.println(i);
  }

  public static void main(String[] args) {
    // insert here
    // 위치가 다르면 인스턴스화는 불가능, 인스턴스화 해야 출력해야 x값을 가질수있음, 선언이 앞으로 와야함
    Variable1 variable1 = new Variable1();
    System.out.println(variable1.x);
    variable1.methodA();
    System.out.println("x는" + variable1.x);
  }
}
