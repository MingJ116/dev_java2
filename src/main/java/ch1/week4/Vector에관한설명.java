/* Collection Framework의 종류

Collection과 Map이 있다 .
Collection 내부엔 2가지가 존재하는데 Set과 List이며
set은 잘 쓰이지 않고 list는 자주 쓰인다.

List = 순서 유지0-> 저장 -> 중복 저장가능.(Index는 달라야함, 식별해야하기때문) 처음부터 저장이 가능
Set = 순서를 유지X -> 저장X, 중복 저장안됨.


List -  객체를 일렬로 늘어 놓은 구조(빈칸넣기 X)
	    객체를 인덱스로 관리(배열과 비슷함, 배열의 0번째에 들어있는것은 Object[주소번지가 담김])
		객체를 저장하면 자동 인덱스가 부여(addMethod호출시) ,
	    인덱스로 객체를 검색(Contains, isEmpty = boolean 타입 [있으면 true 없으면 false), 삭제 할수 있는 기능을 제공.
		addMethod = 객체를 담을 때 쓰임.
		원시형 3가지 int double boolean
		
		
- List interface에 구현된 Method(추상메소드)
		클래스 안에는 변수와 메소드가 호출, 조합
		interface에는 객체를 검색하는 기능이 있다.
		
		
		객체 검색 기능인 int size는 for문 안에 기재
		
		
		객체 삭제
		1. void clear()
		2. E remove(int index)
		3. boolean remove(Object o)
		
		1).
		2). 여러개를 삭제하려면 for문을 이용, 검색에 나온 size를 사용 i <= size
		3). 괄호 안에만 있는 Object를 삭제

		Override는 성능은 다를수있다, 하지만 기본적인 내용은 다르면 안된다
		
		List에는 구현체 클래스들이, 반드시 구현 해야만 하는 공통된 메소드를 정의 해놓은 명세서.(선언)
		
		Ex ) List<기본타입> list = new ArrayList<기본타입>();
		new 다음에는 구현체 클래스가 와야한다 List의 구현체 클래스는 Vector, Arrayslist가 있다.
		- ArrayList는 기다리지 않아도 되니까 빠르다.
		
		<> 안에 있는것은 Generic Type이다(주소번지가 담김) => 내용물을 알고있다는게 장점.
		
		DeptVO -> 변수 3개를 만든다. int를 만들수 있고 String을 쓴다면??
		
		














* */





