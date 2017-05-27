package ToDoLi;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class FM000 extends JFrame {

	JPanel p1 = new JPanel();
	JButton B1 = new JButton("달력");
	JButton B2 = new JButton("시간표");
	JTextArea JT1 = new JTextArea();
	JButton LTB = new JButton("나가기"); // 보기 나가기 버튼
	
	FM000(){
		setTitle("보기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		add(JT1);
		JT1.setLocation(25,80);
		JT1.setSize(930, 430);
		
		p1.setLayout(new GridLayout(1,2,10,0));
		B1.setBackground(new Color(60,184,120));
		B2.setBackground(new Color(60,184,120));
		B1.setFont(new Font("맑은 고딕",Font.BOLD,14));
		B2.setFont(new Font("맑은 고딕",Font.BOLD,14));
		B1.setForeground(Color.WHITE);
		B2.setForeground(Color.WHITE);
		p1.add(B1);
		p1.add(B2);
		p1.setLocation(25, 20);
		p1.setSize(200, 40);
		
		LTB.setBackground(new Color(60,184,120));
		LTB.setFont(new Font("맑은 고딕",Font.BOLD,14));
		LTB.setForeground(Color.WHITE);
		add(LTB);
		LTB.setLocation(855,20);
		LTB.setSize(100,40);
		
		add(LTB);
		add(p1);
		
		setSize(1000, 580);
		setVisible(true);
		
	    LTB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "메뉴로 돌아갑니다.");
				dispose();
				}
			});
	}
	
	public static void main(String[] args){
		new FM000();
	}
}
