package ch1.week5;

import javax.swing.*;

public class JFrameTest extends JFrame {
	JFrameTest(){
//		super("제목");
		this.setTitle ("제목2");
		this.setSize (400,300);
		this.setVisible (true);
		
		
	}
	
	JFrameTest(String title){
		this.setTitle(title);
	}
	
	
	public static void main (String[] args) {
		new JFrameTest();
	}
}
