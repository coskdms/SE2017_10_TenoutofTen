package ToDoLi;

import javax.swing.JFrame;

public class LG000 {
	LG001 loginView;
	ME001 testFrm;

	public static void main(String[] args) {
		// 메인클래스 실행
		LG000 main = new LG000();
		main.loginView = new LG001(); // 로그인창 보이기
		main.loginView.setMain(main); // 로그인창에게 메인 클래스보내기
	}
	
	// 테스트프레임창
	public void showFrameTest(){
		loginView.dispose(); // 로그인창닫기 
		this.testFrm = new ME001(); // 테스트프레임 오픈
	}
}
