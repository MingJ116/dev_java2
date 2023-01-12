package ch1.pastClasses;
//static은 변수앞에 메소드앞에 올수있다.

//static이 있으면 정적변수, 정적 메소드라함.
//인스턴스화 없이 어디서나 호출 가능.
//non-static에서 호출 yes or no ?

public class StaticExam1 {
  int i; // 전역변수는 초기화를 생략할 수 있다. 그러면 디폴드 값은 0이다.
  static int j;

  void methodA() {
    i = i + 1;
    j = i * 2;

    System.out.println("i:" + String.valueOf(i)); // 1
    System.out.println("j:" + String.valueOf(StaticExam1.j)); // 2
  }

  public static void main(String[] args) {
    StaticExam1 staticExam1 = new StaticExam1();
    staticExam1.methodA();
  }
}
