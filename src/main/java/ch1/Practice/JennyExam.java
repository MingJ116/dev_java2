package ch1.Practice;

public class JennyExam {
	// 데이터 변수에 저장된 값이 영문 대문자이면 ="??는 대문자 입니다", 소문자면 "???" 소문자입니다" 로 출력
	
 
	public static void main (String[] args) {
		char i = 'a'; // char는 대소문자를 자동으로 구별
		if (i >= 'a' & i < 'z') { // 판단하는 주체는 if문에서
			System.out.println (i + "는 소문자입니다");
		} else if (i >= 'A' & i < 'Z') {
			System.out.println (i + "대문자 입니다.");
		} else {
			System.out.println (i + " 기타 문장 입니다.");
			
		}
	}
}

