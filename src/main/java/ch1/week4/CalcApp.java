package ch1.week4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcApp extends JFrame implements ActionListener {
//	선언부
	static int i;
	static int j;
	JFrame jf = new JFrame();
	JPanel jp_center = new JPanel();
	JButton jbtn_plus = new JButton("+");
	JButton jbtn_minus = new JButton("-");
	JButton jbtn_mult = new JButton("*");
	JButton jbtn_div = new JButton("/");
	JButton jbtn_equal = new JButton("=");
	JButton jbtn_one = new JButton("1");
	JButton jbtn_two = new JButton("2");
	JButton jbtn_clear = new JButton("C");
	JTextField jtf_display = new JTextField (10);
	JTextField jtf_result = new JTextField ("");
	Font f = new Font("Paryrus", Font.BOLD,40);
	
	double equal(String oprtr){
		double tot=0;
		if ("+".equals(oprtr)) {
			tot = i + j;
		} else if ("-".equals(oprtr)) {
			tot = i - j;
		} else if ("*".equals(oprtr)) {
			tot = i * j;
		} else if ("/".equals(oprtr)) {
			tot = i / (double) j;
		}
		return tot;
	}
	
//	생성부
	public CalcApp(){
		initDisplay();
	}
	
	
	
	
//	화면처리기
	public void initDisplay(){
//		=======================↓버튼 글자 색상↓=======================
		jbtn_plus.setForeground (Color.BLACK);
		jbtn_minus.setForeground (Color.BLACK);
		jbtn_mult.setForeground (Color.BLACK);
		jbtn_div.setForeground (Color.BLACK);
		jbtn_equal.setForeground (Color.BLACK);
		jbtn_one.setForeground (Color.BLACK);
		jbtn_two.setForeground (Color.BLACK);
		jbtn_clear.setForeground (Color.BLACK);
//		=======================↓버튼 글자 폰트↓=======================
		jbtn_plus.setFont (f);
		jbtn_minus.setFont (f);
		jbtn_mult.setFont (f);
		jbtn_div.setFont (f);
		jbtn_equal.setFont (f);
		jbtn_one.setFont (f);
		jbtn_two.setFont (f);
		jbtn_clear.setFont (f);
//		=======================↓버튼 추가↓=======================
		jp_center.add(jbtn_plus);
		jp_center.add(jbtn_minus);
		jp_center.add(jbtn_mult);
		jp_center.add(jbtn_div);
		jp_center.add(jbtn_equal);
		jp_center.add(jbtn_one);
		jp_center.add(jbtn_two);
		jp_center.add(jbtn_clear);
//		=========================================================
		jbtn_plus.addActionListener (this);
		jbtn_minus.addActionListener (this);
		jbtn_mult.addActionListener (this);
		jbtn_div.addActionListener (this);
		jbtn_equal.addActionListener (this);
		jbtn_one.addActionListener (this);
		jbtn_two.addActionListener (this);
		jbtn_clear.addActionListener (this);
//		jtf_result

		
//		=========================================================
		jp_center.setBackground(Color.PINK); // 창 배경 색상 설정
		jp_center.setLayout (new GridLayout(2,6)); // 창에 Grid를 설정
		jtf_display.setEditable (false); // 상단 입력창 on, off
		this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // 창을 닫을때 JVM과 연결을 끊어서 메모리 확보.
		this.add("North" , jtf_display); // 창 북쪽에 입력창 on, off
		this.add("Center", jp_center); // 창 중앙에 패널 만들기
		this.setTitle("the Calculator MJ made"); // 제목표시줄
		this.setSize(500,300); // 창 크기
		this.setVisible(true); // 실행 시 창 띄우기
	}
	
	
	
	
	public static void main (String[] args) {
		new CalcApp();
		
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.LEFT);
	}
	
	@Override
	public void actionPerformed (ActionEvent e) {
		Object obj = e.getSource();
		
		i = Integer.parseInt(jbtn_one.getText ());
		j = Integer.parseInt(jbtn_two.getText ());
		if (jbtn_equal == obj) {
			System.out.println ("계산 클릭");
		}else if (jbtn_one == obj) {
			System.out.println ("입력값1: " + jbtn_one.getText ());
		}else if (jbtn_two == obj) {
			System.out.println ("입력값2: " + jbtn_two.getText ());
//		}else if (jtf)
		}
		}
		}
		
