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

public class TD002 extends JFrame{

   JPanel DTP1 = new JPanel();
   JLabel DTL = new JLabel("삭제할 할일명을 입력하세요.");
   JTextField DTF = new JTextField(20);
   JButton DTB = new JButton("확인");
   JButton DTB2 = new JButton("취소");
   private boolean bDeletCheck;
   
   TD002() {
      setTitle("할일 삭제");
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
      DTB.setLocation(50,100);
      DTB.setSize(70,30);
      
      DTB2.setBackground(new Color(60,184,120));
      DTB2.setFont(new Font("맑은 고딕",Font.BOLD,13));
      DTB2.setForeground(Color.WHITE);
      DTB2.setLocation(150, 100);
      DTB2.setSize(70,30);
      
      add(DTP1);
      add(DTB);
      add(DTB2);
      
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
  				
  				ArrayList TodoNameList = new ArrayList();
  				String TodoName = DTF.getText();
  				
  				for(int findTodoName=0;findTodoName<TodoDatList.size();findTodoName++)
  				{
  					if(findTodoName%14==2) {
  					TodoNameList.add(TodoDatList.get(findTodoName).toString()); 
  					}
  				}
  				
  				if(TodoNameList.contains(TodoName)&&((TodoDatList.indexOf(TodoName)%14==2)||TodoDatList.indexOf(TodoName)==2))
				{
  					int removeValue = TodoDatList.indexOf(TodoName);
					
					int i = 0;
					for(int ListValue=removeValue-2;i<14;i++) 
					{
						TodoDatList.remove(ListValue);
					}
				
					
					try 
					{
						Serialize.saveDat(TodoDatList,"Todo/Todo.dat");
					} 
					
					catch (IOException e3) 
					{					
						e3.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "할일이 삭제되었습니다.");
					dispose();
				}
	
	
		
		else {
			JOptionPane.showMessageDialog(null, "할일 목록에 존재하지 않습니다.");
			dispose();
			}
  			}
      });
      
      DTB2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "할일 삭제가 취소되었습니다.");
				dispose();
			}
      });
   }
   public static void main(String[] args) {
      new TD002();
   }
}