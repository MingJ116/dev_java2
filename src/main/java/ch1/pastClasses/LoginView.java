package ch1.pastClasses;

//java.lang 폴더에 없는 클래스는 모두 import문을 작성함.
import javax.swing.JFrame;

public class LoginView {

  public static void main(String[] args) {
    // 윈도우 운영체제 안에서 창을 만들어 띄울때 사용하는 클래스
    JFrame jf_login = new JFrame();
    // insert here

    int width = 800;
    // 로그인창의 가로길이를 담는 변수 선언
    int height = 600;
    // 로그인창의 세로길이를 담는 변수 선언

    jf_login.setTitle("CyberPunk2077");
    // 내가 만든창의 타이틀바에 제목 표시
    jf_login.setSize(width, height);
    // 내가 만든 창의 가로와 세로크기를 정해주는 메소드 호출

    Return1 r1 = new Return1();
    // 내가 만든 창을 화면에 활성화 또는 비활성화
    jf_login.setVisible(r1.isView1());
  }
}
