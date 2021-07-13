package chapter02;

import java.util.Scanner;

public class StringExample {

	public static void main(String[] args) {
		/*String name = "홍길동";
		String job = "프로게이머";
		System.out.println(name);
		System.out.println(job);*/
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("아이디: ");
		String name = scanner.nextLine();

		System.out.println("패스워드: ");
		String strPassword = scanner.nextLine();
		int password = Integer.parseInt(strPassword);
		
		if(name.equals("java")) {
			if(password==12345) {
				System.out.println("로그인 성공");
			}else {
				System.out.println("로그인실패:패스워드 틀림");
			}
			}else {
				System.out.println("로그인 실패: 아이디존재하지 않음");
				scanner.close();
		}
		
		
	}

}
