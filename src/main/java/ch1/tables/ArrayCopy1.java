package ch1.tables;

import java.util.Arrays;

/*
깊은 복사의 경우 객체의 실제값을 새로운 객체(메모리 공간 으)로 복사 하는 것.
얕은 복사의 경우 객체의 주소 값만을 복사 하는 것.
 */
public class ArrayCopy1 {
	public static void main (String[] args) { // 얕은복사
		ArrayCopy1 ac1 = new ArrayCopy1 ();
		ac1.deepCopy ();
		ac1.deepCopy2 ();
		
		//        기본적인 배열 복사
		//        int [] org = {1,2,3};
		//        int [] org_copy = org;
		//        org_copy[2] = 5;
		//        for (int e:org) {
		//            System.out.println(e);
		//        }for (int e:org_copy) {
		//            System.out.println(e);
		//        }
		
	}
	
	void deepCopy2 () { // 부분 복사
		int[] org = {1, 2, 3};
		int[] org_copy = Arrays.copyOf (org, 1);
		org_copy[0] = 2;
		for (int e : org) {
			System.out.println (e);
		}
		for (int e : org_copy) {
			System.out.println (e);
        }
    }
	
	void deepCopy () { // 전체 복사
		int[] org = {1, 2, 3};
		int[] org_copy = org.clone ();
		org_copy[2] = 5;
		for (int e : org) {
			System.out.println (e);
		}
		for (int e : org_copy) {
			System.out.println (e);
		}
		
	}
	
}

/*
배열 복사
얕은 복사 = 복사된 배열이나 원본 배열이 변경이 될때 서로간의 값이 같이 바뀐다.
깊은 복사
 */