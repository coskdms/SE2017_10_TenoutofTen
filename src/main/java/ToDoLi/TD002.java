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
import javax.swing.JOptionPane;


public class TD002 extends JFrame{
   
   TD002(){
      String[] selections = {"할일1", "할일2", "할일3", "할일4","할일5"};
         Object selected = JOptionPane.showInputDialog(null,"무엇을 삭제하시겠습니까?","할일 삭제",JOptionPane.QUESTION_MESSAGE,null,selections,"할일1");
         if(selected==null)
            JOptionPane.showMessageDialog(null, "취소되었습니다.");
         else
            JOptionPane.showMessageDialog(null, "삭제되었습니다.");
      }
   public static void main(String[] args) {
      new TD002();
   }
}