package ToDoLi;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.text.*;
import javax.swing.table.*;

public class CL001 extends JFrame{
	
	JComboBox comboBoxYear = new JComboBox();
	JComboBox comboBoxSemester = new JComboBox();
	JComboBox comboBoxMon = new JComboBox();
	JComboBox comboBoxDay = new JComboBox();
	JComboBox comboBoxAPM = new JComboBox();
	JComboBox comboBoxHour = new JComboBox();
	JComboBox comboBoxMin = new JComboBox();
			
   JPanel ACP1 = new JPanel(); // 강의정보 라벨 패널
   JPanel ACP2 = new JPanel(); // 강의정보 입력 패널
   JPanel DayP = new JPanel();
   JPanel TimeP = new JPanel();
   
   JLabel ACL1 = new JLabel("강의명");
   JLabel ACL2 = new JLabel("담당교수");
   JLabel ACL3 = new JLabel("강의날짜");
   JLabel ACL4 = new JLabel("강의시간");
   JLabel ACL5 = new JLabel("수강년도");
   JLabel ACL6 = new JLabel("수강학기");
   JTextField ACF1 = new JTextField(20);
   JTextField ACF2 = new JTextField(20);

   JButton ACB = new JButton("추가");

   public CL001(){
      setTitle("강의추가");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(null);
      
      ACP1.setLayout(new GridLayout(6,1,0,25));
      
      ACP1.add(ACL1);
      ACL1.setFont(new Font("맑은 고딕",Font.BOLD,13));
      ACL1.setHorizontalAlignment(JLabel.CENTER);
    
      ACP1.add(ACL2);
      ACL2.setFont(new Font("맑은 고딕",Font.BOLD,13));
      ACL2.setHorizontalAlignment(JLabel.CENTER);
      
      ACP1.add(ACL3);
      ACL3.setFont(new Font("맑은 고딕",Font.BOLD,13));
      ACL3.setHorizontalAlignment(JLabel.CENTER);
      
      ACP1.add(ACL4);
      ACL4.setFont(new Font("맑은 고딕",Font.BOLD,13));
      ACL4.setHorizontalAlignment(JLabel.CENTER);
      
      ACP1.add(ACL5);
      ACL5.setFont(new Font("맑은 고딕",Font.BOLD,13));
      ACL5.setHorizontalAlignment(JLabel.CENTER);
      
      ACP1.add(ACL6);
      ACL6.setFont(new Font("맑은 고딕",Font.BOLD,13));
      ACL6.setHorizontalAlignment(JLabel.CENTER);
         
      ACP1.setLocation(25, 30);
      ACP1.setSize(100,300);
      
      ACP2.setLayout(new GridLayout(6,1,0,25));
      ACP2.add(ACF1);
      ACP2.add(ACF2);
      
      // ACP2.add(ACF3);
      ACP2.add(DayP);
      DayP.setLayout(new GridLayout(1,2,0,0));
      comboBoxMon.setModel(new DefaultComboBoxModel(new String[] {"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"}));
      comboBoxMon.setFont(new Font("맑은 고딕",Font.PLAIN,13));
      comboBoxMon.setMaximumRowCount(3);
      comboBoxMon.setBackground(Color.WHITE);
      comboBoxDay.setModel(new DefaultComboBoxModel(new String[] {"1일", "2일", "3일", "4일", "5일", "6일", "7일", "8일", "9일", "10일", "11일", "12일", "13일", "14일", "15일", "16일", "17일", "18일", "19일", "20일", "21일", "22일", "23일", "24일", "25일", "26일", "27일", "28일", "29일", "30일", "31일"}));
      comboBoxDay.setMaximumRowCount(3);
      comboBoxDay.setFont(new Font("맑은 고딕",Font.PLAIN,13));
      comboBoxDay.setBackground(Color.WHITE);
      DayP.add(comboBoxMon);
      DayP.add(comboBoxDay);
      
      // ACP2.add(ACF4);
      ACP2.add(TimeP);
      TimeP.setLayout(new GridLayout(1,4,0,0));
      comboBoxAPM.setModel(new DefaultComboBoxModel(new String[] {"오전", "오후"}));
      comboBoxAPM.setFont(new Font("맑은 고딕",Font.PLAIN,13));
      comboBoxAPM.setBackground(Color.WHITE);
      comboBoxHour.setModel(new DefaultComboBoxModel(new String[] {"1시", "2시", "3시", "4시", "5시", "6시", "7시", "8시", "9시", "10시", "11시", "12시"}));
      comboBoxHour.setFont(new Font("맑은 고딕",Font.PLAIN,13));
      comboBoxHour.setMaximumRowCount(3);
      comboBoxHour.setBackground(Color.WHITE);
      comboBoxMin.setModel(new DefaultComboBoxModel(new String[] {"00분", "05분", "10분", "15분", "20분", "25분", "30분", "35분", "40분", "45분", "50분", "55분"}));
      comboBoxMin.setFont(new Font("맑은 고딕",Font.PLAIN,13));
      comboBoxMin.setMaximumRowCount(3);
      comboBoxMin.setBackground(Color.WHITE);
      TimeP.add(comboBoxAPM);
      TimeP.add(comboBoxHour);
      TimeP.add(comboBoxMin);
      
      // ACP2.add(ACF5);
  	  comboBoxYear.setModel(new DefaultComboBoxModel(new String[] {"2012년","2013년","2014년","2015년","2016년","2017년", "2018년"}));
  	  comboBoxYear.setFont(new Font("맑은 고딕",Font.PLAIN,13));
  	  comboBoxYear.setMaximumRowCount(3);
  	  comboBoxYear.setBackground(Color.WHITE);
  	  ACP2.add(comboBoxYear);
  	  
  	  // ACP2.add(ACF6);
  	  comboBoxSemester.setModel(new DefaultComboBoxModel(new String[] {"1학기", "2학기"}));
  	  comboBoxSemester.setFont(new Font("맑은 고딕",Font.PLAIN,13));
  	  comboBoxSemester.setBackground(Color.WHITE);
  	  ACP2.add(comboBoxSemester);
  	  
      ACP2.setLocation(150, 30);
      ACP2.setSize(180, 300);
      
      ACB.setBackground(new Color(60,184,120));
      ACB.setFont(new Font("맑은 고딕",Font.BOLD,13));
      ACB.setForeground(Color.WHITE);
      ACB.setLocation(150, 365);
      ACB.setSize(90,35);

      add(ACP1);
      add(ACP2);
      add(ACB);
      
      setSize(400, 480);
      setVisible(true);
      
      ACB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "강의가 추가되었습니다.");
					dispose();
			}
		});
   }
   

   public static void main(String[] args) {
      new CL001();
   }
}
