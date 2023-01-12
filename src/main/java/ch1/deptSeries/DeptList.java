package ch1.deptSeries;

import java.util.Vector;

public class DeptList {
	Vector<DeptVO> vdepts = new Vector<> ();
	
	public static void main (String[] args) {
		DeptList deptList = new DeptList (); // 객체 생성
		deptList.getDeptList ();// 데이터베이스에서 데이터를 가져온다.
		for (int i = 0; i < deptList.vdepts.size (); i++) {// 데이터를 출력한다.
			DeptVO rdVO = deptList.vdepts.get (i);// 데이터를 가져온다.
			System.out.println (rdVO.getDeptno () + ", " + rdVO.getDname () + ", " + rdVO.getLoc ());// 데이터를 출력한다./
		}
		DeptVO dvo = new DeptVO (40, "자재부", "대전");// 데이터를 생성한다.
		int result = deptList.deptInsert (dvo);// 데이터를 삽입한다.
		if (result == 1) {// 삽입이 성공하면
			System.out.println ("등록 되었습니다.");// 메시지를 출력한다.
			for (int i = 0; i < deptList.vdepts.size (); i++) {// 데이터를 출력한다.
				DeptVO rdVO = deptList.vdepts.get (i);// 데이터를 가져온다.
				System.out.println (rdVO.getDeptno () + ", " + rdVO.getDname () + ", " + rdVO.getLoc ());// 데이터를 출력한다.
			}
		}
	}
	
	//부서등록
	int deptInsert (DeptVO pdVO) {// 부서를 등록한다.
		int result = -1;// 결과를 저장할 변수를 선언한다.
		boolean isOk = vdepts.add (pdVO);// 데이터를 추가한다.
		result = isOk ? 1 : 0;// 결과를 저장한다.
		return result;// 결과를 반환한다.
	}
	
	//부서수정 - 부서명과 지역만 수정할 수  있다.
	int deptUpdate (DeptVO pdVO) {// 부서를 수정한다.
		int result = -1;// 결과를 저장할 변수를 선언한다.
		return result;// 결과를 반환한다.
	}
	//부서정보상세
	
	//부서삭제
	int deptDelete (int deptno) {// 부서를 삭제한다.
		int result = -1;// 결과를 저장할 변수를 선언한다.
		return result;// 결과를 반환한다.
	}
	
	//부서 전체 조회
	void getDeptList () {// 부서를 조회한다.
		DeptVO dvo = new DeptVO (10, "개발부", "서울");// 데이터를 생성한다.
		vdepts.add (dvo);// 데이터를 추가한다.
		dvo = new DeptVO (20, "인사부", "인천");// 데이터를 생성한다.
		vdepts.add (dvo);// 데이터를 추가한다.
		dvo = new DeptVO (30, "총무부", "부산");// 데이터를 생성한다.
		vdepts.add (dvo);// 데이터를 추가한다.
	}
}