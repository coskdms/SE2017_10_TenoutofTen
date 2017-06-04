package ToDoLi;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class ME001 extends JFrame{
	private LG000 main; 
	
	

	JTextArea jta1 = new JTextArea(); // 강의출력화면
	JTextArea jta2 = new JTextArea(); // 할일출력화면
	JPanel p1 = new JPanel(); // 강의버튼패널
	JPanel p2 = new JPanel(); // 할일버튼패널
	JPanel p3 = new JPanel(); // 강의목록조회버튼 + <강의목록> 라벨
	JPanel p4 = new JPanel(); // 할일목록조회버튼 + <할일목록> 라벨
	JPanel p5 = new JPanel(); // 검색패널
	JButton jb1 = new JButton();
	JButton jb2 = new JButton();
	JButton jb3 = new JButton(); // 1~3 강의 추가, 변경, 삭제 버튼
	JButton jb4 = new JButton(); 
	JButton jb5 = new JButton();
	JButton jb6 = new JButton();
	JButton jb7 = new JButton(); // 4~7 할일 추가, 변경, 삭제, 한눈보기 버튼
	JButton jb8 = new JButton(); // 강의목록조회 버튼
	JButton jb9 = new JButton(); // 할일목록조회 버튼
	JButton jb10 = new JButton(); // 검색 버튼
	JButton jb11 = new JButton(); // 종료 버튼 (추가
	JTextField jf1 = new JTextField(10); // 검색 입력창
	JLabel courseLabel = new JLabel("<강의목록>");
	JLabel todoLabel = new JLabel("<할일목록>");
	
	ArrayList[][] table = new ArrayList[9][];
	
	ME001(){
		setTitle("투두리_사용자");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JScrollPane js1 = new JScrollPane(jta1); // js1 : 강의 출력
		add(js1);
		js1.setLocation(15,80);
		js1.setSize(1330, 270);
		
		p1.setLayout(new GridLayout(1,4,9,0)); // 강의버튼패널
		jb1 = new JButton("추가");
		jb2 = new JButton("변경");
		jb3 = new JButton("삭제");
		jb11 = new JButton("종료");
		jb1.setBackground(new Color(60,184,120));
		jb2.setBackground(new Color(60,184,120));
		jb3.setBackground(new Color(60,184,120));
		jb11.setBackground(new Color(60,184,120));
		jb1.setFont(new Font("맑은 고딕",Font.BOLD,14));
		jb2.setFont(new Font("맑은 고딕",Font.BOLD,14));
		jb3.setFont(new Font("맑은 고딕",Font.BOLD,14));
		jb11.setFont(new Font("맑은 고딕",Font.BOLD,14));
		jb1.setForeground(Color.WHITE);
		jb2.setForeground(Color.WHITE);
		jb3.setForeground(Color.WHITE);
		jb11.setForeground(Color.WHITE);
		// 추가버튼을 누르면 강의추가 창이 뜨도록
		
		p3.setLayout(new GridLayout(2,1,0,0)); // 강의목록조회버튼  + <강의목록> 라벨
		jb8 = new JButton("강의목록조회");
		jb8.setBackground(new Color(60,184,120));
		jb8.setFont(new Font("맑은 고딕",Font.BOLD,14));
		jb8.setForeground(Color.WHITE);
		p3.add(jb8);
		p3.add(courseLabel);
		courseLabel.setFont(new Font("맑은 고딕",Font.BOLD,14));
		p3.setLocation(15, 10);
		p3.setSize(150, 70);
		
		JScrollPane js2 = new JScrollPane(jta2); // js2 : 과목 출력
		add(js2);
		js2.setLocation(15, 450);
		js2.setSize(1330, 270);
		
		p2.setLayout(new GridLayout(1,4,9,0)); // 할일버튼패널
		jb4 = new JButton("추가");
		jb5 = new JButton("변경");
		jb6 = new JButton("삭제");
		jb7 = new JButton("한눈보기");
		jb4.setBackground(new Color(60,184,120));
		jb5.setBackground(new Color(60,184,120));
		jb6.setBackground(new Color(60,184,120));
		jb7.setBackground(new Color(60,184,120));
		jb4.setFont(new Font("맑은 고딕",Font.BOLD,14));
		jb5.setFont(new Font("맑은 고딕",Font.BOLD,14));
		jb6.setFont(new Font("맑은 고딕",Font.BOLD,14));
		jb7.setFont(new Font("맑은 고딕",Font.BOLD,14));
		jb4.setForeground(Color.WHITE);
		jb5.setForeground(Color.WHITE);
		jb6.setForeground(Color.WHITE);
		jb7.setForeground(Color.WHITE);
		
	
		p4.setLayout(new GridLayout(2,1,0,0)); // 할일목록조회버튼  + <할일목록> 라벨
		jb9 = new JButton("할일목록조회");
		jb9.setBackground(new Color(60,184,120));
		jb9.setFont(new Font("맑은 고딕",Font.BOLD,14));
		jb9.setForeground(Color.WHITE);
		p4.add(jb9);
		p4.add(todoLabel);
		todoLabel.setFont(new Font("맑은 고딕",Font.BOLD,14));
		p4.setLocation(15, 380);
		p4.setSize(150, 70);
		
		p5.setLayout(new GridLayout(1,2,5,0)); // 검색패널
		p5.add(jf1);
		jb10 = new JButton("검색");
		jb10.setBackground(new Color(60,184,120));
		jb10.setFont(new Font("맑은 고딕",Font.BOLD,14));
		jb10.setForeground(Color.WHITE);
		p5.add(jb10);
		p5.setLocation(945, 410);
		p5.setSize(400, 30);
		
		p1.add(jb1);
		p1.add(jb2);
		p1.add(jb3);
		p1.add(jb11);
		p1.setLocation(945, 20);
		p1.setSize(400, 40);
		
		p2.add(jb4);
		p2.add(jb5);
		p2.add(jb6);
		p2.add(jb7);
		p2.setLocation(945, 360);
		p2.setSize(400, 40);
		
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		add(p5);
		
		setSize(1380, 780); // 전체 프로그램 창 크기
		setVisible(true);
		
		jb1.addActionListener(new ActionListener(){
			//private AddCourse addCourse;
			public void actionPerformed(ActionEvent e) {
				new CL001();
			}
		});
		jb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new CL003();
			}
		});
		jb3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new CL002();
			}
		});
		jb11.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "프로그램을 종료합니다.");
				dispose();
			}
		});
		jb4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new TD001();
			}
		});
		jb5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new TD003();
			}
		});
		jb6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new TD002();
			}
		});
		jb7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new FM000();
			}
		});
		jb8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					jta1.setText("");
					
					ArrayList<String> CourseDatList = new ArrayList();
					CourseDatList = Serialize.loadDat("Course/Course.dat");
					
				Iterator iterator = CourseDatList.iterator();
				
				while(iterator.hasNext()) 
					{
						String element = (String) iterator.next();
						jta1.append(element + "	");
					}
				}

				catch (IOException e1) {
					
					e1.printStackTrace();
				}
				jta1.append("\n");
			}
		});
		
	}

	public static void main(String[] args){
		new ME001();
	}
}
