package ch1.pastClasses;

//변수선언에 대한 컨벤션이 있어야함 = 타입이 필요.
public class DeptVOMain {

  public static void main(String[] args) {
    DeptVO deptVO = new DeptVO(); // 인스턴스화
    deptVO.deptno = 10;
    deptVO.dname = "인사과";
    deptVO.loc = "서울";
    System.out.println(deptVO.deptno);// 10
    System.out.println(deptVO.dname);// 인사과
    System.out.println(deptVO.loc); // 서울
    deptVO = new DeptVO(); // 변수선언이 아닌 객체생성 , 6번과 다른 값(변수설정)이며 새로운 값을 설정해줘야한다.
    deptVO.deptno = 30; // 8번과 같지만 이미 10; 을 println을 했기에 새로이 설정된 초기화 값을 아래에 출력.
    System.out.println(deptVO.deptno); // 0 (원시형이기에) deptno를 deptVO에 대입하는 식
    System.out.println(deptVO.dname); // null(참조형이라서)
    System.out.println(deptVO.loc); // null(참조형이니까)

  }
}
