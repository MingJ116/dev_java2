package ch1.pastClasses;

public class Method2 {
  // void일때와 반환형이 있을 때 출력하는 방법이 다르다. you know ?
double m1(double d){
  return 3.5; // 상수를 반환했으니 365일 3.5만 반환.
  }//////end of m1

  public static void main(String[] args) {
    Method2 method2 = new Method2();
    /*메소드 내부에 출력하는 문장이 없는경우 외부의 메소드에서 
     * 그 메소드에서 결정된 값을 출력하려면 반환형이 필요함
     */
    
    
    double result = method2.m1(1.546);
    System.out.println(result);

  }
}
