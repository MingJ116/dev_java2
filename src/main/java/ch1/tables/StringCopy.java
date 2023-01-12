package ch1.tables;

public class StringCopy {

    void methodA(){
    }

    public static void main(String[] args) {
        String str = "hello";
        String str1 = "hello";
        System.out.println(str == str1); // 주소번지가 같은지 ? = 실행하면 true
        System.out.println(str.equals(str1)); // 주소번지가 가르키는 값이 같은지 ? = 이것도 true

        String str2 = new String("안녕안녕");
        String str3 = new String("안녕");
        System.out.println(str2 == str3); // 주소번지가 같은지 ? => false
        System.out.println(str2.equals(str3)); // 주소번지가 같은지 ? => false
    }
}
