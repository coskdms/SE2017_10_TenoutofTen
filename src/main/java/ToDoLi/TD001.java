package ToDoLi;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.text.*;
import javax.swing.table.*;

public class TD001 extends JFrame{

	JPanel ATP1 = new JPanel(); // 할일정보 라벨 패널
	JPanel ATP2 = new JPanel(); // 할일정보 입력 패널
	
	JLabel ATL = new JLabel();		//과목명 라벨
	JLabel ATL7 = new JLabel("과목명");
	JLabel ATL1 = new JLabel("할일");
	JLabel ATL2 = new JLabel("마감일");
	JLabel ATL3 = new JLabel("마감시간");
	JLabel ATL4 = new JLabel("중요여부");
	JLabel ATL5 = new JLabel("완료여부");
	JLabel ATL6 = new JLabel("강의명");
	
	JTextField ATF1 = new JTextField(20); // 할일명
	JTextField ATF2 = new JTextField(20); // 강의명
	JPanel ATP3_DL = new JPanel(); // 마감일
	JComboBox CB_DL_Year = new JComboBox();
	JComboBox CB_DL_Mon = new JComboBox();
	JComboBox CB_DL_Day = new JComboBox();
	JPanel ATP3_tDL = new JPanel(); // 마감시간
	JComboBox CB_DL_APM = new JComboBox();
	JComboBox CB_DL_Hour = new JComboBox();
	JComboBox CB_DL_Min = new JComboBox();
	JPanel ATP5_IS = new JPanel(); // 중요여부
	JComboBox CB_IS = new JComboBox();
	JPanel ATP6_DS = new JPanel(); // 완료여부
	JComboBox CB_DS = new JComboBox();

	JButton ATB = new JButton("추가");
	JButton ATB2= new JButton("취소");
	
    BasicComboBoxRenderer render_IS = (BasicComboBoxRenderer)CB_IS.getRenderer(); // 콤보박스 가운데 정렬을 위해
    BasicComboBoxRenderer render_DS = (BasicComboBoxRenderer)CB_DS.getRenderer(); // 콤보박스 가운데 정렬을 위해
    private static ArrayList<Integer> TodoDatlist;
    
	public TD001(String CourseName){
		setTitle("할일 추가");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		ATP1.setLayout(new GridLayout(6,1,0,25));
		
		ATP1.add(ATL7);
		ATL7.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    ATL7.setHorizontalAlignment(JLabel.CENTER);
		
		ATP1.add(ATL1);
        ATL1.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    ATL1.setHorizontalAlignment(JLabel.CENTER);
	    
		ATP1.add(ATL2);
        ATL2.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    ATL2.setHorizontalAlignment(JLabel.CENTER);
	    
		ATP1.add(ATL3);
        ATL3.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    ATL3.setHorizontalAlignment(JLabel.CENTER);
	    
		ATP1.add(ATL4);
        ATL4.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    ATL4.setHorizontalAlignment(JLabel.CENTER);
	    
		ATP1.add(ATL5);
        ATL5.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    ATL5.setHorizontalAlignment(JLabel.CENTER);
	    
	    
	    ATP1.setLocation(20, 55);
	    ATP1.setSize(100, 250);
	    
	    ATP2.setLayout(new GridLayout(6,1,0,25));
	    
	    ATL = new JLabel(CourseName);;
	    ATP2.add(ATL);
	    
	    ATP2.add(ATF1);
	    ATP2.add(ATP3_DL);
	    ATP3_DL.setLayout(new GridLayout(1,3,0,0));
	    CB_DL_Year.setModel(new DefaultComboBoxModel(new String[] {"2012년","2013년","2014년","2015년","2016년","2017년", "2018년"}));
	    CB_DL_Year.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    CB_DL_Year.setMaximumRowCount(3);
	    CB_DL_Year.setBackground(Color.WHITE);
	    CB_DL_Mon.setModel(new DefaultComboBoxModel(new String[] {"01월", "02월", "03월", "04월", "05월", "06월", "07월", "08월", "09월", "10월", "11월", "12월"}));
	    CB_DL_Mon.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    CB_DL_Mon.setMaximumRowCount(3);
	    CB_DL_Mon.setBackground(Color.WHITE);
	    CB_DL_Day.setModel(new DefaultComboBoxModel(new String[] {"01일", "02일", "03일", "04일", "05일", "06일", "07일", "08일", "09일", "10일", "11일", "12일", "13일", "14일", "15일", "16일", "17일", "18일", "19일", "20일", "21일", "22일", "23일", "24일", "25일", "26일", "27일", "28일", "29일", "30일", "31일"}));
	    CB_DL_Day.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    CB_DL_Day.setMaximumRowCount(3);
	    CB_DL_Day.setBackground(Color.WHITE);
	    ATP3_DL.add(CB_DL_Year);
	    ATP3_DL.add(CB_DL_Mon);
	    ATP3_DL.add(CB_DL_Day);
	    
	    ATP2.add(ATP3_tDL);
	    ATP3_tDL.setLayout(new GridLayout(1,3,0,0));
	    CB_DL_APM.setModel(new DefaultComboBoxModel(new String[] {"오전", "오후"}));
	    CB_DL_APM.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    CB_DL_APM.setBackground(Color.WHITE);
	    CB_DL_Hour.setModel(new DefaultComboBoxModel(new String[] {"1시", "2시", "3시", "4시", "5시", "6시", "7시", "8시", "9시", "10시", "11시", "12시"}));
	    CB_DL_Hour.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    CB_DL_Hour.setMaximumRowCount(3);
	    CB_DL_Hour.setBackground(Color.WHITE);
	    CB_DL_Min.setModel(new DefaultComboBoxModel(new String[] {"00분", "05분", "10분", "15분", "20분", "25분", "30분", "35분", "40분", "45분", "50분", "55분"}));
	    CB_DL_Min.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    CB_DL_Min.setMaximumRowCount(3);
	    CB_DL_Min.setBackground(Color.WHITE);
	    ATP3_tDL.add(CB_DL_APM);
	    ATP3_tDL.add(CB_DL_Hour);
	    ATP3_tDL.add(CB_DL_Min);
	    
  
	    ATP2.add(CB_IS);
	    CB_IS.setModel(new DefaultComboBoxModel(new String[] {" ","★", "★★", "★★★"}));
	    CB_IS.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    CB_IS.setBackground(Color.WHITE);
	    render_IS.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // 콤보박스 가운데 정렬
	   	    
	    ATP2.add(CB_DS);
	    CB_DS.setModel(new DefaultComboBoxModel(new String[] {"완료", "미완료"}));
	    CB_DS.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    CB_DS.setBackground(Color.WHITE);
	    render_DS.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // 콤보박스 가운데 정렬

	    
	    ATP2.setLocation(150, 55);
	    ATP2.setSize(200, 250);
	    
	    ATB.setBackground(new Color(60,184,120));
	    ATB.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    ATB.setForeground(Color.WHITE);
	    ATB.setLocation(90, 350);
	    ATB.setSize(90,35);
	    
	    ATB2.setBackground(new Color(60,184,120));
	    ATB2.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    ATB2.setForeground(Color.WHITE);
	    ATB2.setLocation(230, 350);
	    ATB2.setSize(90,35);
	    
	    add(ATP1);
	    add(ATP2);
	    add(ATB);
	    add(ATB2);
	    
		setSize(400, 480);
		setVisible(true);
		
		ATB.addActionListener(new ActionListener(){
	         public void actionPerformed(ActionEvent e) {
	            String TodoName = ATF1.getText();
	            String TodoYear = (String)CB_DL_Year.getSelectedItem();
	            String TodoMon = (String)CB_DL_Mon.getSelectedItem();
	            String TodoDay = (String)CB_DL_Day.getSelectedItem();
	            String TodoApm = (String)CB_DL_APM.getSelectedItem();
	            String TodoHour = (String)CB_DL_Hour.getSelectedItem();
	            String TodoMin = (String)CB_DL_Min.getSelectedItem();
	            String TodoStar = (String)CB_IS.getSelectedItem();
	            String TodoFinish = (String)CB_DS.getSelectedItem();
	            
	            ArrayList<String> TodoDatList = new ArrayList();
	            ArrayList<String> CourseDatList = new ArrayList();
	            
	            File file = new File("Todo/Todo.dat");
	            
	            if(file.isFile()) {         
	            try {
	               TodoDatList = Serialize.loadDat("Todo/Todo.dat");
	            } catch (IOException e4) {
	               
	               e4.printStackTrace();
	            }
	            }
	            
	            File file2 = new File("Course/Course.dat");
	            
	            if(file2.isFile()) {         
	            try {
	            	CourseDatList = Serialize.loadDat("Course/Course.dat");
	            } catch (IOException e4) {
	               
	               e4.printStackTrace();
	            }
	            }
	            
	            ArrayList NameCheck = new ArrayList();
	            
	            for(int Course=0;Course<CourseDatList.size();Course++)
	            {
	            	if(Course%9==1)
	            		NameCheck.add(CourseDatList.get(Course).toString());	            		
	            }
	            
	            if(NameCheck.contains(TodoName))
	            {
	            	System.out.println(NameCheck);
	            	JOptionPane.showMessageDialog(null, "할일 이름은 모든 강의 이름과 동일할 수 없습니다.");
	            }
	           
	            else {
	            	
	            	ArrayList OverlapList = new ArrayList();

	               for(int Overlap=0;Overlap<TodoDatList.size();Overlap++) //할일 중복등록 방지
	               	{
	               	   if(Overlap%14==2&&TodoDatList.size()>2) 
	               	   {
	               		   OverlapList.add(TodoDatList.get(Overlap));
	               	   }
	               	}

	               if(OverlapList.contains(TodoName))
	               	   JOptionPane.showMessageDialog(null, "이미 추가된 할일 입니다.");

	               else  {
	            	   OverlapList.clear();	
	            	  
	               int TodoValue = TodoDatList.size();            
	      
	                  TodoDatList.add("\n");
	                  
	                  
	               TodoDatList.add(CourseName);
	               TodoDatList.add(TodoName);
	               TodoDatList.add(TodoYear);
	               TodoDatList.add(TodoMon);
	               TodoDatList.add(TodoDay);
	               TodoDatList.add(TodoApm);
	               TodoDatList.add(TodoHour);
	               TodoDatList.add(TodoMin);
	               TodoDatList.add("");
	               TodoDatList.add("");
	               TodoDatList.add("");               
	               TodoDatList.add(TodoStar);
	               TodoDatList.add(TodoFinish);
	               
	               
				try 
				{
					Serialize.saveDat(TodoDatList,"Todo/Todo.dat");
				} 
				catch (IOException e3) 
				{					
					e3.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "할일이 추가되었습니다.");
				dispose();
			}
	            }
	         }
		});
		
		
		ATB2.addActionListener(new ActionListener(){
	         public void actionPerformed(ActionEvent e) {
	        	 JOptionPane.showMessageDialog(null, "할일 추가가 취소되었습니다.");
	        	 dispose();
	         }
		});
		}
	
	public static void main(String[] args){

	}
}