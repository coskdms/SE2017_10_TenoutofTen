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
      
   }
   public static void main(String[] args) {
      String[] selections = {"할일1", "할일2", "할일3", "할일4","할일5"};
      JOptionPane.showInputDialog(null, "삭제할 할일을 선택해주세요.", "할일 삭제", JOptionPane.QUESTION_MESSAGE, null, selections, "해야할 일");
      new TD002();

   }
}