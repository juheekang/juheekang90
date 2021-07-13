package chapter02;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		int input = scanner.nextInt();
//		System.out.println("입력된 내용은:" +input );
//		String name = "감자바;"
		
	/*	String name = "감자바";
		int age = 25;
		String tel1 = "010", tel2="123", tel3="4567";
			System.out.println("이름: "+ name);
			System.out.print("나이: "+ age +"\n");
			System.out.printf("전화: %1$s - %2$s -%3$s", tel1,tel2,tel3);*/
		System.out.println("[필수 정보 입력]");
		System.out.print("1. 이름: ");
		String str1 = scanner.nextLine();
		System.out.print("2. 주민번호 앞 6자리: ");
		String str2 = scanner.nextLine();
		System.out.print("3. 전화번호: ");
		String str3 = scanner.nextLine();
		System.out.println();
		
		System.out.println("[입력한 내용]");
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		scanner.close();
	}

}
