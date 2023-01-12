package ch1.pastClasses;

// Static은 메소드 이름 앞에도 올 수 있고 변수명 앞에도 올 수 있다.
// 그렇다면 인스턴스화 하는것과 뭐가 다름?
public class Pride {
  // 자동차 이름
  static String carName = "2023년형 프라이드";
  // 자동차 색상
  String carColor = "흰색";
  // 바퀴수를 담는 변수 선언 
  int wheelNum = 4;

  // 에러에는 두가지가 있다
  // 문법에러, 런타임 에러(Exception)
  public static void main(String[] args) {
        // 변수 이름 앞에 Static이 있으면 인스턴스화 없이도 호출이 가능함.
        // 이 말은 같은 객체를 복제하지 않는다는 의미포함(납득)
    System.out.println(carName);//인스턴스화 라고 함 - Pride객체가 메모리 상주 -> 호출이 가능한 상태
    Pride myCar = new Pride();//myCar를 인스턴스 변수라 한다.
        // insert here 
    System.out.println("22번 라인에서 ====> " + myCar);
      myCar.carColor = "보라색";
        // myCar = null; // 주소번지가 가리키는 객체가 사라짐, 그러나 타입은 남았다.
        // myCar.carColor = "보라색";
     System.out.println(myCar);  // myCar.carColor = "purple"; 이 위치에 카 컬러를 옮기면 null pointer exception이 발생한다. (구현체 클래스가 없을때)
        
      myCar = new Pride(); //새로운 주소번지를 갖는다
        //myCar.carColor = "검정색";
    System.out.println(myCar == myCar);
    System.out.println(myCar.carColor); 

        /*myCar.carColor = "검정색";
        System.out.println(myCar.carColor);*/
  }
}// 전역 변수는 인스턴스화 해야 호출할수 있다
// 클래스나 오브젝트는 디폴트가 null이다. int는 0이 맞다