package Exercise;

import java.util.Random;
import java.util.Scanner;

public class Exercise53 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		String[] array = {"가위", "바위", "보"};
//		int ranNum = random.nextInt(3);
		System.out.print("가위 바위 보를 입력하세요: ");
		String player = scanner.nextLine();
		System.out.println("게이머: " + player);
//		String computer = array[ranNum]
		String computer = array[random.nextInt(array.length)];
		System.out.println("인공지능 컴퓨터: " + computer );
		
		String result = "";
		
		if(player.equals(computer)) {
			result = "비김!";
		} else if (player.equals("가위") && computer.equals("바위")
				 ||player.equals("바위") && computer.equals("보")
				 ||player.equals("보") && computer.equals("가위")) {
				result = "인공지능 컴퓨터 승리!";
			}else {
				result = "게이머 승리!";
			}
		System.out.println("결과: "+ result);
		
	}
}
