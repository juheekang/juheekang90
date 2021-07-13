package Exercise;

import java.util.Scanner;

public class Exercise25 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("500원짜리 동전의 갯수:");
		int input = scanner.nextInt();
		System.out.print("100원짜리 동전의 갯수:");
		int input2 = scanner.nextInt();
		System.out.print("50원짜리 동전의 갯수:");
		int input3 = scanner.nextInt();
		System.out.print("10원짜리 동전의 갯수:");
		int input4 = scanner.nextInt();
		System.out.print("저금통 안의 동전의 총 액수:"+ ((input*500)+(input2*100)+(input3*50)+(input4*10)));
		
		scanner.close();


		

	}

}
