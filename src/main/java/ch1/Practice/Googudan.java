package ch1.Practice;

public class Googudan {
	public static void main (String[] args) {
		for (int i = 2; i <= 9; i++) { // 이 조건식을 만족해야 9번 for 문으로 넘어감
//			2가 9보다 작거나 같을떄까지 한 개씩 증가시키는 반복문
			System.out.println (i + "단을 출력합니다");
			
//			for (int j = 1; j <= 9; j++) { // 1이 9보다 작거나 같은 수가 될 때까지 1씩 추가시킴
//				System.out.println (i + "x" + j + " = " + i * j + "\t"); // \t를 붙이면 좌우로 정렬되어 출력되어야하는데 지금 안되고 있음
			}
			System.out.println (); // 각 단의 출력이 끝나면 print가 아닌 println으로 다음줄에 표기를 요청, 여백 한칸을 추가하여 출력
		}
	}
//}
