package Exercise;

import java.util.Scanner;

public class Exercise26 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 숫자 >>");
		int a = scanner.nextInt();
		System.out.print("두번째 숫자 >>");
		int b = scanner.nextInt();
		System.out.print("세번째 숫자 >>");
		int c = scanner.nextInt();
		
		int tmp = 0;
		System.out.println(a + "," + b + "," + c);
		if(a > b) {
			tmp = a;
			a = b;
			b = tmp;
		}
		System.out.println(a + "," + b + "," + c);
		if(b > c) {
			tmp = b;
			b = c;
			c = tmp;
		}
		System.out.println(a + "," + b + "," + c);
		if(a > b) {
			tmp = b;
			b = a;
			a = tmp;
			
		System.out.println(a + "<" + b + "<" + c);
		scanner.close();
		}

	}

}
