package ch1.quiz1216;
//0부터 9사이의 임의의 수를 100개 채번하여 한 줄에 10개씩 출력하고 그 숫자의 빈도 수를 계산하여 출력하시오

public class Quiz3 {
	int counts[] = new int[10];
	
	int[] initArray(int datas[], int size) {
		int i;
		for (i = 0; i < datas.length; i++) {
			datas[i] = (int) (Math.random() * 10);
		}
		dataPrint(datas);
		return datas;
	}
	
	// 빈도검사 배열에 들어있는 숫자를 증가시킴
	void numberCount(int[] datas) {
		int index = 0;
		for (int i = 0; i < 100; i++) {
			index = datas[i];
			counts[index]++;
		}
	}
	
	void dataPrint(int[] datas) {
		for (int i = 0; i < datas.length; i++) {
			System.out.print(datas[i]);
			if (i % 10 == 9) {
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		Quiz3 q3 = new Quiz3();
		int datas[] = new int[100];
		q3.initArray(datas, 100);
		q3.numberCount(datas);
		for (int i = 0; i < q3.counts.length; i++) {
			System.out.print(q3.counts[i] + " ");
		}
	}
}
