package ch1.pastClasses;

class Param {
  int ival; // 0->100->500 전역변수, static이 없으니 non-static.
}

public class TestParam { // TestParam은 전역변수, 참조형(reference) 변수, 간접참조방식
  void effectParam(Param p) { // 인스턴스화라고 할수 없음. 선언만 되어있고 생성이 안되어있기에, 값이 초기화 되어있지 않다. 이런 경우엔 null pointer
                              // exception이라한다
    // 메소드의 (파라미터)자리는 지변이다. 기준은 메소드안에서 선언을 했기에
    p = new Param();// insert here - 여기에 p = new Param()이 있으면 결과가 달라진다 아니다 같다?????, p의 주소번지는 @abcd1235
    p.ival = 500;
    System.out.println("sub ival ===> " + p.ival);
  }

  public static void main(String[] args) { // 이곳이 Entry point라서 가장먼저 실행되는건 Main method(Main Thread)이다.
    TestParam tp = new TestParam(); // 15번의 메인메소드 안에 있기때문에 17번은 지역변수다.
    Param p = new Param();
    //p.ival = 100;
    tp.effectParam(p); // 주소번지 @abcd1234 넘긴다
    System.out.println("main ival ===> " + p.ival);
  }
}
/*
 * Thread가 있어야 .exe 생성가능, 한정된 자원을 여러사람이 공유하려면 Thread가 필요, Maint method안에 있기때문에
 * effectParam이 실행됨
 * 
 * 
 * testparam도 지변이다, 메인메소드 안에 있어서.
 * 해당 메소드에 대한 역할은 ival에 대해 초기화
 * 10번 라인 주석하기전엔 ival이 0이였다가
 * 
 * 선언 -> 라인 - > 표기
 * 
 * 메인메소드 안에 있는 내용을 사용하고 싶으면
 * Static은 복사본을 갖지 않는다, 오로지 하나.
 * 4번의 int ival;은 초기화가 되어있지 않으니 기본값은 0, 전역변수라서 초기화를 하지 않아도 선언할수있다(컨벤션)
 * 17번에서 p값을 초기화 하지 않았으니 p.ival은 0이다.
 * 메인메소드를 JVM이 호출함
 * 24번라인에서 p를 넘김 주소번지 @abcd1234넘긴다 고로 p는(8번줄도) @abcd1234가 됨
 * 10번의 주석을 풀어놓는다 하더라도 12번의p는 10번의 p와 대응이 되기에 p의 주소번지는 @abcd1235로 바뀐
 * 
 * 
 * 전역변수(컨벤션) 초기화를 생략할수있다. why = 생성자가 대리 생성.
 * 지역변수는 불가능(컴파일에러)
 * 
 * 전변과 지변의 공통점 = 한번에 하나만 담을수있다. 동시에 2개는 X
 * 차이점 = 지역변수는 초기화를 생략 불가능, 반드시 초기화를 해줘야함 = 클래스급이 아니기때문에, (인스턴스변수.변수명)으로
 * 호출할수있는것은 전변
 * 
 * 선언부에 오는것은 전변
 * 선언부는 클래스 선언한 그 다음(메소드 내부X)
 * 
 * -메소드 선언 방법-
 * (접근제한자) (static) [void,int,double,Param] [이름] (파라미터) 
 * 메소드를 선언 할때 앞에 접근제한자가 올수있지만 생략할수있다. [int,void,Param]가 올수있다
 * 그 다음엔 리턴타입, 그 앞에는 static이 붙을수있지만 optional이다.
 * 
 * int i = 3 이라고 했을시 int는 반환이다
 * 
 * 
 * 
 * public static void Give(Meplz)
 *    String i = 
 * 
 */