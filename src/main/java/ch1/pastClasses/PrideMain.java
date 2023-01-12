package ch1.pastClasses;

public class PrideMain {
  public static void main(String[] args) {
    Pride myCar = new Pride();
    Pride herCar = new Pride();
    // insert here
    herCar = myCar; // 이렇게 표현해야 true 판정

    System.out.println(myCar == herCar); // '==' 2개의 피 연산자가 같은지를 검사하는것, 결과가 다르니 false 판정
  }

}