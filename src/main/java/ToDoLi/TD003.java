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

public class TD003 extends JFrame{

   JPanel DTP1 = new JPanel();
   JLabel DTL = new JLabel("변경할 할일명을 입력하세요.");
   JTextField DTF = new JTextField(100);
   JButton DTB = new JButton("확인");
   private boolean bDeletCheck;
   
   TD003() {
      setTitle("할일 변경");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(null);
      
      DTP1.setLayout(new GridLayout(2,1,0,0));
      DTL.setFont(new Font("맑은 고딕",Font.PLAIN,13));
      DTL.setHorizontalAlignment(JLabel.CENTER);
      DTP1.add(DTL);
      DTP1.add(DTF);
      
      DTP1.setLocation(45,25);
      DTP1.setSize(180,60);
      
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
				
				ArrayList TodoDatList = new ArrayList();
				
				File file = new File("Todo/Todo.dat");
				
				if(file.isFile()) {	
					try {
						TodoDatList = Serialize.loadDat("Todo/Todo.dat");
					} 
				
					catch (IOException e4) {
						e4.printStackTrace();
					}
				}
				
				String TodoName = DTF.getText();
				
				if(TodoDatList.contains(TodoName)&&(TodoDatList.indexOf(TodoName)%14==2))
				{
						int removeValue = TodoDatList.indexOf(TodoName);
							
							
						JOptionPane.showMessageDialog(null, TodoName +" 할일을 변경합니다.");
						new TD004(TodoName);
						dispose();
				}		
				
				else 
				{
					JOptionPane.showMessageDialog(null, "해당 할일 목록에 존재하지 않습니다.");
					dispose();
				}
			}
		});
      
   }
   
   public static void main(String[] args) {
      new TD003();
   }
}