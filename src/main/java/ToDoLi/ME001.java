package ToDoLi;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Comparator;
import java.util.Collections;



public class ME001 extends JFrame {
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
	JButton jb6 = new JButton();// 4~6할일 추가, 변경, 삭제
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
		jb4.setBackground(new Color(60,184,120));
		jb5.setBackground(new Color(60,184,120));
		jb6.setBackground(new Color(60,184,120));
		jb4.setFont(new Font("맑은 고딕",Font.BOLD,14));
		jb5.setFont(new Font("맑은 고딕",Font.BOLD,14));
		jb6.setFont(new Font("맑은 고딕",Font.BOLD,14));
		jb4.setForeground(Color.WHITE);
		jb5.setForeground(Color.WHITE);
		jb6.setForeground(Color.WHITE);
		
		
	
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
		
		JPanel FinishTodoPanel = new JPanel();
		JCheckBox FinishTodoCheckbox = new JCheckBox("완료된 항목 숨기기");			
		FinishTodoPanel.setLayout(new GridLayout());
		FinishTodoPanel.setLocation(97, 423);
		FinishTodoPanel.setSize(150,20);
		FinishTodoPanel.add(FinishTodoCheckbox);
		add(FinishTodoPanel);
		
		/* Sort = 1(과목명 정렬), 2(마감기한), 3(실제 마감일), 4(완료 여부) */
		/* AscDesc = 1(오름차순 정렬), 2(내림차순 정렬) */
		
		JPanel WhatSortPanel = new JPanel();
		JRadioButton WSort01 = new JRadioButton("과목명으로 정렬");
		JRadioButton WSort02 = new JRadioButton("마감기한으로 정렬");
		JRadioButton WSort03 = new JRadioButton("실제 마감일로 정렬");
		JRadioButton WSort04 = new JRadioButton("완료 여부로 정렬");
		ButtonGroup WSortgroup = new ButtonGroup();
		WSortgroup.add(WSort01); WSortgroup.add(WSort02); WSortgroup.add(WSort03); WSortgroup.add(WSort04);
		WhatSortPanel.setLayout(new GridLayout(4,1));
		WhatSortPanel.add(WSort01); WhatSortPanel.add(WSort02); WhatSortPanel.add(WSort03); WhatSortPanel.add(WSort04);
		WhatSortPanel.setLocation(250, 350);
		WhatSortPanel.setSize(200,100);
		add(WhatSortPanel);
		
		JPanel HowSortPanel = new JPanel();
		JRadioButton HSort01 = new JRadioButton("오름차순으로 정렬");
		JRadioButton HSort02 = new JRadioButton("내림차순으로 정렬");
		ButtonGroup HSortgroup = new ButtonGroup();
		HSortgroup.add(HSort01); HSortgroup.add(HSort02);
		HowSortPanel.setLayout(new GridLayout(2,1));
		HowSortPanel.add(HSort01); HowSortPanel.add(HSort02);
		HowSortPanel.setLocation(450, 350);
		HowSortPanel.setSize(200,50);
		add(HowSortPanel);
		
		p5.setLayout(new GridLayout(1,2,5,0)); // 검색패널
		jb10 = new JButton("검색");
		jb10.setBackground(new Color(60,184,120));
		jb10.setFont(new Font("맑은 고딕",Font.BOLD,14));
		jb10.setForeground(Color.WHITE);
		p5.add(jb10);
		p5.setLocation(1217, 410);
		p5.setSize(127, 30);
		jf1.setLocation(945,410);
		jf1.setSize(265,30);
		
		p1.add(jb1);
		p1.add(jb2);
		p1.add(jb3);
		p1.add(jb11);
		p1.setLocation(945, 20);
		p1.setSize(400, 40);
		
		p2.add(jb4);
		p2.add(jb5);
		p2.add(jb6);
		p2.setLocation(945, 360);
		p2.setSize(400, 40);
		
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		add(p5);
		add(jf1);
		
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
				new TD001_1_test();
			}
		});
		jb5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new TD003_test();
			}
		});
		jb6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new TD002_test();
			}
		});
		jb8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				try {
					jta1.setText("");
					
					ArrayList<String> CourseDatList = new ArrayList();
					CourseDatList = Serialize.loadDat("Course/Course.dat");
					
				for(int ListSize=0;ListSize<CourseDatList.size();ListSize++)
					{
						jta1.append(CourseDatList.get(ListSize) + "	");
					}
				}
						
				catch (IOException e1) {
					
					e1.printStackTrace();
				}
				jta1.append("\n");
			}
		});
		
		jb9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				try {
					jta2.setText("");
					
					ArrayList<String> TodoDatList = new ArrayList();
					TodoDatList = Serialize.loadDat("Todo/Todo.dat");
					
					
					/* WSort = 1(과목명 정렬), 2(마감기한), 3(실제 마감일), 4(완료 여부) */
					/* HSort = 1(오름차순 정렬), 2(내림차순 정렬) */
					
					ArrayList<String> WSortList = new ArrayList();
					
					int WSort=0;
					
					
					
					if(WSort01.isSelected())
						WSort=1;
					else if(WSort02.isSelected())
						WSort=2;
					else if(WSort03.isSelected())
						WSort=3;
					else if(WSort04.isSelected())
						WSort=4; 
					
					for(int WSList=0;WSList<TodoDatList.size();WSList++)
					{
						if(WSort==1&&WSList%13==0)
							WSortList.add(TodoDatList.get(WSList+1));
						
						else if(WSort==2&&WSList%13==0)
							WSortList.add(TodoDatList.get(WSList+2));
						
						else if(WSort==3&&WSList%13==0)
							WSortList.add(TodoDatList.get(WSList+8));
						
						else if(WSort==4&&WSList%13==0)
						WSortList.add(TodoDatList.get(WSList+12));
						
					}
					
					ArrayList<String> HSortList = new ArrayList();
					HSortList = WSortList;
					
					int HSort=0;
					
					if(HSort01.isSelected())
						HSort=1;					
					else if(HSort02.isSelected())
						HSort=2;
					
					if(HSort==1)
					{
						
						Asending asending = new Asending();
						Collections.sort(HSortList,asending);
						
					}
					
					else if(HSort==2)
					{
						
						Desending desending = new Desending();
						Collections.sort(HSortList,desending);
						
					} 
					
					ArrayList WHsort = new ArrayList();
					
					for(int KeyValue=0;KeyValue<HSortList.size();KeyValue++)
					{
							if(TodoDatList.contains(HSortList.get(KeyValue)));
							{
								WHsort.add(TodoDatList.indexOf(HSortList.get(KeyValue)));
								
							}
					}
					
					if(HSort==0&&(WSort==1||WSort==2||WSort==3||WSort==4))
						JOptionPane.showMessageDialog(null, "정렬 방식을 선택해주세요.");
					else if(WSort==0&&(HSort==1||HSort==2))
						JOptionPane.showMessageDialog(null, "정렬 항목을 선택해주세요.");
					else {
						
						int CheckValue;
						
						if(FinishTodoCheckbox.isSelected())
							CheckValue=1;
						else
							CheckValue=0;
						
						if((WSort==1||WSort==2||WSort==3||WSort==4)&&CheckValue==1)
						{
							ArrayList Overlap = new ArrayList();
							
							for(int KeyValue=0;KeyValue<WHsort.size();KeyValue++)
							{
								for(int ListValue=0;ListValue<TodoDatList.size();ListValue++)
								{
									String WHsortString = WHsort.get(KeyValue).toString();
									String TodoDatListString = String.valueOf(ListValue);
									
									
									if(WSort==1&&WHsortString.equals(TodoDatListString)&&TodoDatList.get(ListValue+11).equals("미완료"))
									{
										
										for(int i=ListValue-1;i<(ListValue+12);i++)
										{
											jta2.append(TodoDatList.get(i) + "	");
										}
									}
									
								/*	else if(WSort==2&&WHsortString.equals(TodoDatListString)&&TodoDatList.get(ListValue+11).equals("미완료"))
									{
										System.out.println("진입4");
										for(int i=ListValue-1;i<(ListValue+12);i++)
										{
											jta2.append(TodoDatList.get(i) + "	");
										}
									}
									
									else if(WSort==3&&WHsortString.equals(TodoDatListString)&&TodoDatList.get(ListValue+11).equals("미완료"))
									{
										System.out.println("진입4");
										for(int i=ListValue-1;i<(ListValue+12);i++)
										{
											jta2.append(TodoDatList.get(i) + "	");
										}
									} */
									
									else if(WSort==4&&WHsortString.equals(TodoDatListString)&&TodoDatList.get(ListValue+11).equals("미완료")&!Overlap.contains(TodoDatListString))
									{
										Overlap.add(TodoDatListString);
										for(int i=ListValue-12;i<(ListValue+1);i++)
										{
											jta2.append(TodoDatList.get(i) + "	");
										}
									}
								}
								
							}
							Overlap.clear();
						}
						
						
						
						
						else if((WSort==1||WSort==2||WSort==3||WSort==4)&&CheckValue==0)
						{
							ArrayList Overlap = new ArrayList();
							
							for(int KeyValue=0;KeyValue<WHsort.size();KeyValue++)
							{
								for(int ListValue=0;ListValue<TodoDatList.size();ListValue++)
								{
									String WHsortString = WHsort.get(KeyValue).toString();
									String TodoDatListString = String.valueOf(ListValue);
									
									if(WSort==1&&WHsortString.equals(TodoDatListString))
									{
										
										for(int i=ListValue-1;i<(ListValue+12);i++)
										{
											jta2.append(TodoDatList.get(i) + "	");
										}
									}
									
								/*	else if(WSort==2&&WHsortString.equals(TodoDatListString))
									{
										System.out.println("진입4");
										for(int i=ListValue-1;i<(ListValue+12);i++)
										{
											jta2.append(TodoDatList.get(i) + "	");
										}
									}
									
									else if(WSort==3&&WHsortString.equals(TodoDatListString))
									{
										System.out.println("진입4");
										for(int i=ListValue-1;i<(ListValue+12);i++)
										{
											jta2.append(TodoDatList.get(i) + "	");
										}
									} */
									
									else if(WSort==4&&WHsortString.equals(TodoDatListString)&!Overlap.contains(TodoDatListString))
									{
										Overlap.add(TodoDatListString);
										System.out.println("완료체크 안하고 정렬");
										for(int i=ListValue-12;i<(ListValue+1);i++)
										{
											jta2.append(TodoDatList.get(i) + "	");
										}
									}
								}
								
							}
							Overlap.clear();
						}	
						
						
						else{
							
						for(int NotSort=0;NotSort<TodoDatList.size();NotSort++)
						{	
						
						if(CheckValue==1&&NotSort%13==0&&TodoDatList.get(NotSort+12).equals("미완료"))
						{ 
							for(int i=NotSort;i<(NotSort+13);i++)
							{
								jta2.append(TodoDatList.get(i) + "	");
							}
						}
						
						else if(CheckValue==0&&NotSort%13==0)
						{
							for(int i=NotSort;i<(NotSort+13);i++)
							{
								jta2.append(TodoDatList.get(i) + "	");
							}
						}
						
						}
						
						
							
						}
					
					}
						
					}
				
				catch (IOException e3) {
				
				e3.printStackTrace();
			}
			jta2.append("\n");
		}
	});
		jb10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String SearchText =jf1.getText().trim();
				
				if(SearchText.length()==0)
				{
					JOptionPane.showMessageDialog(null, "검색할 할일 이름을 입력해 주십시오.");
				}
				
				else 
				{
				
					try {
						ArrayList<String> TodoDatList = new ArrayList();
						TodoDatList = Serialize.loadDat("Todo/Todo.dat");
					
							if(TodoDatList.contains(SearchText))
							{
							      	jf1.setText("");
							      	jta2.setText("");
									JOptionPane.showMessageDialog(null, "할일 '"+SearchText+"' 의 검색 결과를 표시합니다.");
									
									int SearchTextValue = TodoDatList.indexOf(SearchText);
									
									for(int i=SearchTextValue-1;i<SearchTextValue+12;i++) 
									{
										jta2.append(TodoDatList.get(i) + "	");
									}
							}
					
							else
							{
								JOptionPane.showMessageDialog(null, "입력한 할일이 목록에 존재하지 않습니다.");
							}
						}
				
					catch (IOException e3) 
					{
						e3.printStackTrace();
					}
				}
				
				
				
				
			}
		});
}
	
	class Desending implements Comparator<String> {
		
		@Override
		public int compare(String arg0, String arg1) {
			return arg1.compareTo(arg0);
		}
	}

	class Asending implements Comparator<String> {
		
		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
	}
	
	public static void main(String[] args){
		new ME001();
	}
}