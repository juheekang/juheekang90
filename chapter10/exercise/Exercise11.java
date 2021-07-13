package chapter10.exercise;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Exercise11 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			try {
//				int dividend;
//				int divisor;
				System.out.print("어떤 수로 나누시겠습니까?>> ");
				int dividend = scanner.nextInt();
				System.out.print("어떤 수를 나누시겠습니까?>> ");
				int divisor = scanner.nextInt();
				int result = dividend / divisor;
				System.out.println(String.format("%d / %d = %d", dividend, divisor,result));
				scanner.close();
//				return;
//				while문이 중지되지않음 
//				문자가 입력되면 엔터가 지워지지않고 남아서 무한반복
//				catch에 scanner.next();를 입력해야 엔터가 제거됨
				break; 
			} catch (InputMismatchException e) {
				System.err.println("잘못된 입력입니다. 다시 입력해주세요.");
				scanner.next();
			} catch (ArithmeticException e) {
				System.err.println("0으로 나눌수 없습니다. 다시 입력해주세요.");
				
			}
		}
	}
}