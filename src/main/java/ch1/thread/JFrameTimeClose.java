package ch1.thread;

import javax.swing.*;

public class JFrameTimeClose extends JFrame {
	public JFrameTimeClose() {
        super("JFrameTest-5초후 창 닫기");
		this.setSize(500,500);
		this.setVisible(true);
		//대기시킴
		try {
			Thread.sleep (5000); // 3초 카운트
		}catch(InterruptedException ie){
            ie.printStackTrace ();
		}
		setVisible (false);	// 창닫기
		//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JFrameTimeClose();
	
		
	}
}
