package ch1.Network;

import javax.swing.*;
import java.awt.*;

public class TimeClientView extends JFrame {
	//===============================선언부===============================
	JLabel jlb_timer = new JLabel ("Current Time", JLabel.CENTER);
	Font f = new Font ("굴림체", Font.BOLD, 30);
	
	//================================생성자===============================
	TimeClientView () {
		initDisplay ();
	
}
	
//===============================화면처리부===============================
	public void initDisplay () {
		Thread th = new TimeClient (jlb_timer);
		th.start ();
		jlb_timer.setFont (f);
		this.add("Center", jlb_timer);
		this.setSize (400,300);
		this.setVisible(true);
		
	}
	
//============================메인메소드===============================
	public static void main (String[] args) {
		new TimeClientView ();
	}
}
