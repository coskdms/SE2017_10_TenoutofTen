package ToDoLi;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

public class CL002 extends JFrame{

   JPanel DCP1 = new JPanel();
   JLabel DCL = new JLabel("삭제할 강의명을 입력하세요.");
   JTextField DCF = new JTextField(20);
   JButton DCB = new JButton("확인");
   private boolean bDeletCheck;
   
   CL002(){
      setTitle("강의 삭제");
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
				JOptionPane.showMessageDialog(null, "강의가 삭제되었습니다.");
				dispose();
			}
		});
      
   }
   
   public static void main(String[] args) {
      new CL002();
   }
}