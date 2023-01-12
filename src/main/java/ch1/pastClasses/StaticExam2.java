package ch1.pastClasses;
//static은 변수앞에 메소드앞에 올수있다.

//static이 있으면 정적변수, 정적 메소드라함.
//인스턴스화 없이 어디서나 호출 가능.
//non-static에서 호출 yes or no ?

public class StaticExam2 {

  public static void main(String[] args) {

    StaticExam1 staticExam1 = new StaticExam1();
    StaticExam1 staticExam2 = new StaticExam1();
    StaticExam1 staticExam3 = new StaticExam1();
    staticExam1.methodA();
    staticExam2.i = 5;
    staticExam3.i = 1; 
    
    System.out.println(staticExam1.i); // 1
    System.out.println(staticExam2.i); // 5
    System.out.println(staticExam3.i); // 1
  }

}
