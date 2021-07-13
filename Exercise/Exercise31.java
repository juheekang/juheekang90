package Exercise;

import java.util.Scanner;

public class Exercise31 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫 번째 숫자를 입력하세요:");
		int firNum = scanner.nextInt();
		System.out.print("두 번째 숫자를 입력하세요:");
		int secNum = scanner.nextInt();
		
		int a = ((firNum+secNum)+Math.abs(firNum-secNum))/2;
		int b = ((firNum+secNum)-Math.abs(firNum-secNum))/2;	
		
		System.out.print("큰 수를 작은 수로 나눈 몫은 " + a/b +"이고,"+"나머지는" + a%b +"이다.");
		
		scanner.close();
	}

}
