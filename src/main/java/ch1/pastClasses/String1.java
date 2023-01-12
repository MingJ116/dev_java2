package ch1.pastClasses;

public class String1 {
  public static void main(String[] args) {
    String s1 = "안녕";
    String s2 = "안녕";
    // 주소번지가 가르키는 값을 비교하려면 equals 라는 메소드를 찾아볼것.
    String s3 = new String("안녕");
    String s4 = new String("안녕");
      
    System.out.println(s1.equals(s2));
    System.out.println(s1==s2);
    System.out.println(s3==s4);
    System.out.println(s3.equals(s4));
    
    // s1과 s2의 주소번지는 같은지, 참 혹은 거짓 선택하기, 그리고 이유
    // s3과 s4의 주소번지가 같은지, 선택 후 결과에 대해 토론 
    // 만약 s3이 가르키는 문자열이 s4와 같은지 비교하려면 ? 구글링해보기
    // 스트링은 원시형 타입중 유일하게 문자열값 그대로출력, 2가지로 초기화 가능, 대입연산자를 통해 또는 new라는 예약어를 통해 또 다른 객체를 생성가능
    // new를 이용했을때 내부적 메커니즘이 다름.

    // Equals는 입력값만 비교, == 연산자는 주소값까지 비교
  }
}
