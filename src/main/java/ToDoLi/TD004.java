package ToDoLi;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import java.util.*;
import java.text.*;
import javax.swing.table.*;

public class TD004 extends JFrame{

	JPanel ATP1 = new JPanel(); // 할일정보 라벨 패널
	JPanel ATP2 = new JPanel(); // 할일정보 입력 패널
	
	JLabel ATL1 = new JLabel("할일");
	JLabel ATL2 = new JLabel("마감일");
	JLabel ATL2_t = new JLabel("마감시간");
	JLabel ATL3 = new JLabel("실제마감일");
	JLabel ATL4 = new JLabel("중요여부");
	JLabel ATL5 = new JLabel("완료여부");
	
	JLabel ATF1 = new JLabel();;
	
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
	JComboBox CB_IS = new JComboBox();
	JPanel ATP6_DS = new JPanel(); // 완료여부
	JComboBox CB_DS = new JComboBox();
	
	
	JButton ATB = new JButton("변경");
	JButton ATB2 = new JButton("취소");
	
	BasicComboBoxRenderer render_IS = (BasicComboBoxRenderer)CB_IS.getRenderer(); // 콤보박스 가운데 정렬을 위해
	BasicComboBoxRenderer render_DS = (BasicComboBoxRenderer)CB_DS.getRenderer(); // 콤보박스 가운데 정렬을 위해
	private static ArrayList<Integer> TodoDatlist;	
	
	public TD004(String TodoName){
		setTitle("할일 변경");
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

	    ATP1.setLocation(20, 30);
	    ATP1.setSize(100, 300);
	    
	    ATP2.setLayout(new GridLayout(7,1,0,15));
	    ATF1 = new JLabel(TodoName);;
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
	    
	    ATP2.add(ATP4_RDL);
	    ATP4_RDL.setLayout(new GridLayout(1,3,0,0));
	    CB_RDL_Year.setModel(new DefaultComboBoxModel(new String[] {"2012년","2013년","2014년","2015년","2016년","2017년", "2018년"}));
	    CB_RDL_Year.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    CB_RDL_Year.setMaximumRowCount(3);
	    CB_RDL_Year.setBackground(Color.WHITE);
	    CB_RDL_Mon.setModel(new DefaultComboBoxModel(new String[] {"01월", "02월", "03월", "04월", "05월", "06월", "07월", "08월", "09월", "10월", "11월", "12월"}));
	    CB_RDL_Mon.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    CB_RDL_Mon.setMaximumRowCount(3);
	    CB_RDL_Mon.setBackground(Color.WHITE);
	    CB_RDL_Day.setModel(new DefaultComboBoxModel(new String[] {"01일", "02일", "03일", "04일", "05일", "06일", "07일", "08일", "09일", "10일", "11일", "12일", "13일", "14일", "15일", "16일", "17일", "18일", "19일", "20일", "21일", "22일", "23일", "24일", "25일", "26일", "27일", "28일", "29일", "30일", "31일"}));
	    CB_RDL_Day.setFont(new Font("맑은 고딕",Font.PLAIN,13));
	    CB_RDL_Day.setMaximumRowCount(3);
	    CB_RDL_Day.setBackground(Color.WHITE);
	    ATP4_RDL.add(CB_RDL_Year);
	    ATP4_RDL.add(CB_RDL_Mon);
	    ATP4_RDL.add(CB_RDL_Day);
	    

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
	    ATP2.setLocation(150, 30);
	    ATP2.setSize(200, 300);
	    
	    ATB.setBackground(new Color(60,184,120));
	    ATB.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    ATB.setForeground(Color.WHITE);
	    ATB.setLocation(100, 365);
	    ATB.setSize(90,35);
	    
	    ATB2.setBackground(new Color(60,184,120));
	    ATB2.setFont(new Font("맑은 고딕",Font.BOLD,13));
	    ATB2.setForeground(Color.WHITE);
	    ATB2.setLocation(200, 365);
	    ATB2.setSize(90,35);
	    
	    ArrayList TodoDatList = new ArrayList();
	    
	    File file = new File("Todo/Todo.dat");
	    
	    if(file.isFile()) {		
			try 
			{
				TodoDatList = Serialize.loadDat("Todo/Todo.dat");
			} 
			catch (IOException e4) 
			{			
				e4.printStackTrace();
			}
		}
	    
	    int ChangeValue = TodoDatList.indexOf(TodoName)+1;
	    
	    CB_DL_Year.setSelectedItem(TodoDatList.get(ChangeValue));
	    ChangeValue++;
	    CB_DL_Mon.setSelectedItem(TodoDatList.get(ChangeValue));
	    ChangeValue++;
	    CB_DL_Day.setSelectedItem(TodoDatList.get(ChangeValue));
	    ChangeValue++;
	    CB_DL_APM.setSelectedItem(TodoDatList.get(ChangeValue));
	    ChangeValue++;
	    CB_DL_Hour.setSelectedItem(TodoDatList.get(ChangeValue));
	    ChangeValue++;
	    CB_DL_Min.setSelectedItem(TodoDatList.get(ChangeValue));
	    ChangeValue++;
	    CB_RDL_Year.setSelectedItem(TodoDatList.get(ChangeValue));
	    ChangeValue++;
	    CB_RDL_Mon.setSelectedItem(TodoDatList.get(ChangeValue));
	    ChangeValue++;
	    CB_RDL_Day.setSelectedItem(TodoDatList.get(ChangeValue));
	    ChangeValue++;
	    CB_IS.setSelectedItem(TodoDatList.get(ChangeValue));
	    ChangeValue++;
	    CB_DS.setSelectedItem(TodoDatList.get(ChangeValue));

	    
	    add(ATP1);
	    add(ATP2);
	    add(ATB);
	    add(ATB2);
	    
		setSize(400, 480);
		setVisible(true);

	    ATB.addActionListener(new ActionListener(){
	    	
			public void actionPerformed(ActionEvent e) {
				
				String TodoDLTearchange = (String)CB_DL_Year.getSelectedItem();
				String TodoDLMonchange =(String)CB_DL_Mon.getSelectedItem();
				String TodoDLDaychange =(String)CB_DL_Day.getSelectedItem();
				String TodoDLAPMchange =(String)CB_DL_APM.getSelectedItem();
				String TodoDLHourchange =(String)CB_DL_Hour.getSelectedItem();
				String TodoDLMinchange =(String)CB_DL_Min.getSelectedItem();
				String TodoRDLYearchange =(String)CB_RDL_Year.getSelectedItem();
				String TodoRDLMonchange =(String)CB_RDL_Mon.getSelectedItem();
				String TodoRDLDaychange =(String)CB_RDL_Day.getSelectedItem();
				String TodoISchange =(String)CB_IS.getSelectedItem();
				String TodoDSchange =(String)CB_DS.getSelectedItem();
				
				ArrayList TodoDatList = new ArrayList();
				
				File file = new File("Todo/Todo.dat");
				
				if(file.isFile()) {			
					try {
						TodoDatList = Serialize.loadDat("Todo/Todo.dat");
			
					} catch (IOException e4) {
						
						e4.printStackTrace();
					}
				}
				
				int ChangeValue = TodoDatList.indexOf(TodoName)+1; 
				
				TodoDatList.remove(ChangeValue);
				TodoDatList.add(ChangeValue,TodoDLTearchange);
				ChangeValue++;
				TodoDatList.remove(ChangeValue);
				TodoDatList.add(ChangeValue,TodoDLMonchange);
				ChangeValue++;
				TodoDatList.remove(ChangeValue);
				TodoDatList.add(ChangeValue,TodoDLDaychange);
				ChangeValue++;
				TodoDatList.remove(ChangeValue);
				TodoDatList.add(ChangeValue,TodoDLAPMchange);
				ChangeValue++;
				TodoDatList.remove(ChangeValue);
				TodoDatList.add(ChangeValue,TodoDLHourchange);
				ChangeValue++;
				TodoDatList.remove(ChangeValue);
				TodoDatList.add(ChangeValue,TodoDLMinchange);
				ChangeValue++;
				TodoDatList.remove(ChangeValue);
				TodoDatList.add(ChangeValue,TodoRDLYearchange);
				ChangeValue++;
				TodoDatList.remove(ChangeValue);
				TodoDatList.add(ChangeValue,TodoRDLMonchange);
				ChangeValue++;
				TodoDatList.remove(ChangeValue);
				TodoDatList.add(ChangeValue,TodoRDLDaychange);
				ChangeValue++;
				TodoDatList.remove(ChangeValue);
				TodoDatList.add(ChangeValue,TodoISchange);
				ChangeValue++;
				TodoDatList.remove(ChangeValue);
				TodoDatList.add(ChangeValue,TodoDSchange);
				
				try 
				{
					Serialize.saveDat(TodoDatList,"Todo/Todo.dat");
				} 
				catch (IOException e3) 
				{					
					e3.printStackTrace();
				}
				

				JOptionPane.showMessageDialog(null, "할일이 변경되었습니다.");
				dispose();
				}
			});
	    ATB2.addActionListener(new ActionListener(){
	    	
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "할일 변경이 취소되었습니다."); 
				dispose();
			}
	      
	    });
	}
	
	public static void main(String[] args){
		
	}
}