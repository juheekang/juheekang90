package Exercise;

import java.util.Scanner;

public class Exercise23 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 수를 입력하세요:");
		int input = scanner.nextInt();
		System.out.print("두번째 수를 입력하세요:");
		int input2 = scanner.nextInt();
		String result = (input>input2) ? "true" : "false" ;
		System.out.print("첫번째 수가 두번째 수보다 큰가?:" +  result );
//		boolean input3 = scanner.nextBoolean();
		
		scanner.close();
	}
}
