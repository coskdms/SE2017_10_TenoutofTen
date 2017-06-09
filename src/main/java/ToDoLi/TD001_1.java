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

public class TD001_1 extends JFrame{

   JPanel DTP1 = new JPanel();
   JLabel DTL = new JLabel("할일을 추가할 강의명을 입력하세요.");
   JTextField DTF = new JTextField(100);
   JButton DTB = new JButton("확인");
   private boolean bDeletCheck;
protected GraphicsConfiguration CourseName;
   
   TD001_1() {
      setTitle("할일 추가");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(null);
      
      DTP1.setLayout(new GridLayout(2,1,0,0));
      DTL.setFont(new Font("맑은 고딕",Font.PLAIN,13));
      DTL.setHorizontalAlignment(JLabel.CENTER);
      DTP1.add(DTL);
      DTP1.add(DTF);
      
      DTP1.setLocation(25,25);
      DTP1.setSize(220,60);
      
      DTB.setBackground(new Color(60,184,120));
      DTB.setFont(new Font("맑은 고딕",Font.BOLD,13));
      DTB.setForeground(Color.WHITE);
      DTB.setLocation(100,100);
      DTB.setSize(70,30);
      
      add(DTP1);
      add(DTB);
      
      setSize(280,200);
      setVisible(true);
      
      DTB.addActionListener(new ActionListener(){
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
				
				String CourseName = DTF.getText();
				
				if(CourseDatList.contains(CourseName)&&(CourseDatList.indexOf(CourseName)%9==1))
				{
						int removeValue = CourseDatList.indexOf(CourseName);
							
							
						JOptionPane.showMessageDialog(null, CourseName +" 의 할일을 추가합니다.");
						new TD001(CourseName);
						dispose();
				}		
				
				else 
				{
					JOptionPane.showMessageDialog(null, "강의가 목록에 존재하지 않습니다.");
					dispose();
				}
			}
		});
      
   }
   
   public static void main(String[] args) {
      new TD001_1();
   }
}





