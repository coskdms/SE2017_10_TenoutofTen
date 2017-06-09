package ToDoLi;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;

public class CL003 extends JFrame{

   JPanel DCP1 = new JPanel();
   JLabel DCL = new JLabel("변경할 강의명을 입력하세요.");
   JTextField DCF = new JTextField(20);
   JButton DCB = new JButton("확인");
   private boolean bDeletCheck;
   
   CL003() {
      setTitle("강의 변경");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(null);
      
      DCP1.setLayout(new GridLayout(2,1,0,0));
      DCL.setFont(new Font("맑은 고딕",Font.PLAIN,13));
      DCL.setHorizontalAlignment(JLabel.CENTER);
      DCP1.add(DCL);
      DCP1.add(DCF);
      
      DCP1.setLocation(45,25);
      DCP1.setSize(180,60);
      
      DCB.setBackground(new Color(60,184,120));
      DCB.setFont(new Font("맑은 고딕",Font.BOLD,13));
      DCB.setForeground(Color.WHITE);
      DCB.setLocation(100,100);
      DCB.setSize(70,30);
      
      add(DCP1);
      add(DCB);
      
      setSize(280,200);
      setVisible(true);
      
      DCB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				ArrayList CourseDatList = new ArrayList();
				
				File file = new File("Course/Course.dat");
				
				if(file.isFile()) {	
					try {
						CourseDatList = Serialize.loadDat("Course/Course.dat");
					} 
				
					catch (IOException e2) {
						e2.printStackTrace();
					}
				}
				
				String courseName = DCF.getText();
				
				if(CourseDatList.contains(courseName)&&(CourseDatList.indexOf(courseName)%9==1))
				{
						int removeValue = CourseDatList.indexOf(courseName);
							
							
						JOptionPane.showMessageDialog(null, courseName +" 강의를 변경합니다.");
						new CL004(courseName);
						dispose();
				}		
				
				else 
				{
					JOptionPane.showMessageDialog(null, "해당 강의가 목록에 존재하지 않습니다.");
					dispose();
				}
			}
		});
      
   }
   
   public static void main(String[] args) {
      new CL003();
   }
}