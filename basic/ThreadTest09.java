package kr.or.ddit.basic;

import java.util.Random;

import javax.swing.JOptionPane;

/*
    컴퓨터와 가위 바위 보를 진행하는 프로그램 작성하기
    
    컴퓨터의 가위 바위 보는 난수를 이용해서 구하고,
    사용자의 입력은 showInputDialog()메서드를 이용해서 입력 받는다.
    
    입력 시간은 5초로 제한하고 카운트 다운을 한다.
    5초안에 입력이 없으면 게임에 진것으로 처리한다.
    5초안에 입력이 완료되면 승패를 구해서 출력한다.
    
    결과예시) 
    	-- 결 과 --
    	컴퓨터 : 가위
    	사용자 : 바위
    	결 과 : 당신이 이겼습니다.
    	
    5초안에 입력을 못했을 경우
    	-- 결 과 --
    	시간초과로 당신이 졌습니다.
 */
public class ThreadTest09 {

	public static void main(String[] args) {

		inputData th1 = new inputData();
		count th2 = new count();

		th1.start();
		th2.start();
	}
}

// 컴퓨터와 사용자의 데이터 입력 스레드
class inputData extends Thread {
	public static boolean inputCheck;

	Random ran = new Random();

	String[] data = { "가위", "바위", "보" };
	int index = ran.nextInt(3) + 1; // 0 ~ 2 사이의 난수 만들기
	String computer = data[index - 1];
	String user = null;
//	String user = JOptionPane.showInputDialog("가위 바위 보를 입력하세요");
//	inputCheck = true;

	@Override
	public void run() {

		// 가위,바위,보가 아닌 다른값이 입력되었을경우
		do {
			user = JOptionPane.showInputDialog("가위 바위 보를 입력하세요");
		} while (!(user.equals("가위") || user.equals("바위") || user.equals("보")));
//		} while ( !user.equals("가위") && !user.equals("바위") && !user.equals("보"));

		inputCheck = true;

		String result = ""; // 결과가 저장될 변수 선언
		if (computer.equals(user)) {
			result = "비겼습니다.";
		} else if (computer.equals("가위") && user.equals("바위") || computer.equals("바위") && user.equals("보")
				|| computer.equals("보") && user.equals("가위")) {
			result = "당신이 이겼습니다.";
		} else {
			result = "당신이 졌습니다.";
		}
		System.out.println("-- 결 과 --");
		System.out.println("컴퓨터: " + computer);
		System.out.println("사용자: " + user);
		System.out.println("결과: " + result);
		System.exit(0);
	}
}

class count extends Thread {
	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {
			if (inputData.inputCheck == true) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println("-- 결 과 --\n시간초과로 당신이 졌습니다.");
		System.exit(0);
	}
}