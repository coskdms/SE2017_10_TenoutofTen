package ToDoLi;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.text.*;
import javax.swing.table.*;

public class TD003 extends JFrame{

	JPanel ATP1 = new JPanel(); // 할일정보 라벨 패널
	JPanel ATP2 = new JPanel(); // 할일정보 입력 패널
	
	JLabel ATL1 = new JLabel("할일");
	JLabel ATL2 = new JLabel("마감일");
	JLabel ATL2_t = new JLabel("마감시간");
	JLabel ATL3 = new JLabel("실제마감일");
	JLabel ATL4 = new JLabel("중요여부");
	JLabel ATL5 = new JLabel("완료여부");
	JLabel ATL6 = new JLabel("알람");
	
	JTextField ATF1 = new JTextField(20); // 할일명
	JPanel ATP3_DL = new JPanel(); // 마감일
	JComboBox CB_DL_Year = new JComboBox();
	JComboBox CB_DL_Mon = new JComboBox();
	JComboBox CB_DL_Day = new JComboBox();
	JPanel ATP3_tDL = new JPanel(); // 마감시간
	JComboBox CB_DL_APM = new JComboBox();
	JComboBox CB_DL_Hour = new JComboBox();
	JComboBox CB_DL_Min = new JComboBox();
	JPanel ATP4_RDL = new JPanel(); // 실제마감일
	JComboBox CB_RDL_Year = new JComboBox();
	JComboBox CB_RDL_Mon = new JComboBox();
	JComboBox CB_RDL_Day = new JComboBox();
	JPanel ATP5_IS = new JPanel(); // 중요여부
	JRadioButton IS1 = new JRadioButton("★");
	JRadioButton IS2 = new JRadioButton("★★");
	JRadioButton IS3 = new JRadioButton("★★★");
	JPanel ATP6_DS = new JPanel(); // 완료여부
	JRadioButton DS1 = new JRadioButton("완료");
	JRadioButton DS2 = new JRadioButton("미완료");
	JPanel ATP7_AR = new JPanel(); // 알람
	JRadioButton AR1 = new JRadioButton("알람ON");
	JRadioButton AR2 = new JRadioButton("알람OFF");
	
	JButton ATB = new JButton("변경");
	
	public TD003(){
		setTitle("할일변경");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		ATP1.setLayout(new GridLayout(7,1,0,15));
		
		ATP1.add(ATL1);
        ATL1.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    ATL1.setHorizontalAlignment(JLabel.CENTER);
	    
		ATP1.add(ATL2);
        ATL2.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    ATL2.setHorizontalAlignment(JLabel.CENTER);
	    
	    ATP1.add(ATL2_t);
        ATL2_t.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    ATL2_t.setHorizontalAlignment(JLabel.CENTER);	    
	    
		ATP1.add(ATL3);
        ATL3.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    ATL3.setHorizontalAlignment(JLabel.CENTER);
	    
		ATP1.add(ATL4);
        ATL4.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    ATL4.setHorizontalAlignment(JLabel.CENTER);
	    
		ATP1.add(ATL5);
        ATL5.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    ATL5.setHorizontalAlignment(JLabel.CENTER);
	    
		ATP1.add(ATL6);
        ATL6.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    ATL6.setHorizontalAlignment(JLabel.CENTER);
		
	    ATP1.setLocation(20, 30);
	    ATP1.setSize(100, 300);
	    
	    ATP2.setLayout(new GridLayout(7,1,0,15));
	    ATP2.add(ATF1);
	    
	    ATP2.add(ATP3_DL);
	    ATP3_DL.setLayout(new GridLayout(1,3,0,0));
	    CB_DL_Year.setModel(new DefaultComboBoxModel(new String[] {"2012년","2013년","2014년","2015년","2016년","2017년", "2018년"}));
	    CB_DL_Year.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    CB_DL_Year.setMaximumRowCount(3);
	    CB_DL_Year.setBackground(Color.WHITE);
	    CB_DL_Mon.setModel(new DefaultComboBoxModel(new String[] {"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"}));
	    CB_DL_Mon.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    CB_DL_Mon.setMaximumRowCount(3);
	    CB_DL_Mon.setBackground(Color.WHITE);
	    CB_DL_Day.setModel(new DefaultComboBoxModel(new String[] {"1일", "2일", "3일", "4일", "5일", "6일", "7일", "8일", "9일", "10일", "11일", "12일", "13일", "14일", "15일", "16일", "17일", "18일", "19일", "20일", "21일", "22일", "23일", "24일", "25일", "26일", "27일", "28일", "29일", "30일", "31일"}));
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
	    
	    ATP2.add(ATP4_RDL);
	    ATP4_RDL.setLayout(new GridLayout(1,3,0,0));
	    CB_RDL_Year.setModel(new DefaultComboBoxModel(new String[] {"2012년","2013년","2014년","2015년","2016년","2017년", "2018년"}));
	    CB_RDL_Year.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    CB_RDL_Year.setMaximumRowCount(3);
	    CB_RDL_Year.setBackground(Color.WHITE);
	    CB_RDL_Mon.setModel(new DefaultComboBoxModel(new String[] {"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"}));
	    CB_RDL_Mon.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    CB_RDL_Mon.setMaximumRowCount(3);
	    CB_RDL_Mon.setBackground(Color.WHITE);
	    CB_RDL_Day.setModel(new DefaultComboBoxModel(new String[] {"1일", "2일", "3일", "4일", "5일", "6일", "7일", "8일", "9일", "10일", "11일", "12일", "13일", "14일", "15일", "16일", "17일", "18일", "19일", "20일", "21일", "22일", "23일", "24일", "25일", "26일", "27일", "28일", "29일", "30일", "31일"}));
	    CB_RDL_Day.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    CB_RDL_Day.setMaximumRowCount(3);
	    CB_RDL_Day.setBackground(Color.WHITE);
	    ATP4_RDL.add(CB_RDL_Year);
	    ATP4_RDL.add(CB_RDL_Mon);
	    ATP4_RDL.add(CB_RDL_Day);
	    
	    ButtonGroup bg1 = new ButtonGroup(); // 하나만 선택되게하기위해서 그룹화
	    ATP2.add(ATP5_IS);
	    ATP5_IS.add(IS1);
	    bg1.add(IS1);
	    IS1.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    ATP5_IS.add(IS2);
	    bg1.add(IS2);
	    IS2.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    ATP5_IS.add(IS3);
	    bg1.add(IS3);
	    IS3.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    
	    ButtonGroup bg2 = new ButtonGroup(); // 하나만 선택되게하기위해서 그룹화
	    ATP2.add(ATP6_DS);
	    ATP6_DS.add(DS1);
	    bg2.add(DS1);
	    DS1.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    ATP6_DS.add(DS2);
	    bg2.add(DS2);
	    DS2.setFont(new Font("맑은 고딕",Font.PLAIN,13));

	    ButtonGroup bg3 = new ButtonGroup(); // 하나만 선택되게하기위해서 그룹화
	    ATP2.add(ATP7_AR);
	    ATP7_AR.add(AR1);
	    bg3.add(AR1);
	    AR1.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    ATP7_AR.add(AR2);
	    bg3.add(AR2);
	    AR2.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    
	    ATP2.setLocation(150, 30);
	    ATP2.setSize(200, 300);
	    
	    ATB.setBackground(new Color(60,184,120));
	    ATB.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    ATB.setForeground(Color.WHITE);
	    ATB.setLocation(150, 365);
	    ATB.setSize(90,35);
	    
	    add(ATP1);
	    add(ATP2);
	    add(ATB);
	    
		setSize(400, 480);
		setVisible(true);
		
	}
	
	public static void main(String[] args){
		new TD003();
	}
}

