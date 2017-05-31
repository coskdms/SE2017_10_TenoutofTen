package ToDoLi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;


public class LG001 extends JFrame{
	private LG000 main;
	private ME001 testFrm;
	private JButton btnLogin;
	private JButton btnInit;
	private JPasswordField passText;
	private JTextField userText;
	private boolean bLoginCheck;

	private JLabel logo = new JLabel(new ImageIcon("img/logo.png"));
	
	public static void main(String[] args) {
		//new LoginView();
	}

	public LG001() {
		// setting
		setTitle("투두리");
		setSize(440, 600);
		setResizable(false);
		setLocation(800, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// panel
		JPanel panel = new JPanel();
		placeLoginPanel(panel);
		
		
		// add
		add(panel);
		
		// visible
		setVisible(true);
	}
	
	
	public void placeLoginPanel(JPanel panel){
		panel.setLayout(null);	
		
		logo.setBounds(55,55,320,300);
		panel.add(logo);
		
		JLabel userLabel = new JLabel("학번");
		userLabel.setFont(new Font("맑은 고딕",Font.BOLD,14));
		userLabel.setHorizontalAlignment(JLabel.CENTER);
		userLabel.setBounds(110, 400, 40, 25);
		panel.add(userLabel);
		
		JLabel passLabel = new JLabel("PW");
		passLabel.setFont(new Font("맑은 고딕",Font.BOLD,14));
		passLabel.setHorizontalAlignment(JLabel.CENTER);
		passLabel.setBounds(110, 430, 40, 25);
		panel.add(passLabel);
		
		userText = new JTextField(20);
		userText.setBounds(170, 400, 160, 25);
		panel.add(userText);
		
		passText = new JPasswordField(20);
		passText.setBounds(170, 430, 160, 25);
		panel.add(passText);
		passText.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				isLoginCheck();			
			}
		});
		
		btnLogin = new JButton("로그인");
		btnLogin.setBackground(new Color(60,184,120));
		btnLogin.setFont(new Font("맑은 고딕",Font.BOLD,14));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(170, 470, 100, 30);
		panel.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isLoginCheck();
			}
		});
	}
	
	public void isLoginCheck(){
		if(userText.getText().equals("201511065") && new String(passText.getPassword()).equals("1234")){  //아이디 "201511065" 비번 "1234"
			JOptionPane.showMessageDialog(null, "Success");
			bLoginCheck = true;
			
			// 로그인 성공이라면 매니져창 뛰우기
			if(isLogin()){
				main.showFrameTest(); // 메인창 메소드를 이용해 창뛰우기
			}					
		}else{
			JOptionPane.showMessageDialog(null, "Faild");
		}
	}

	
	// mainProcess와 연동
	public void setMain(LG000 main) {
		this.main = main;
	}
	

	public boolean isLogin() {		
		return bLoginCheck;
	}

}