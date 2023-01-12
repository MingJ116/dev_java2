package ch1.grade1221;

public class ArrayExam {
	public static void main (String[] args) {
		String[] sArr = new String[] {"빨강","노랑","파랑"};
		for ( int i = 0; i < sArr.length; i++ )
			System.out.print (sArr[i] + ","); //for문을 이용한 출력
		System.out.println ();
//		System.out.println (Arrays.toString(sArr)); // Array.toString 메서드를 이용한 출력
	}
}
