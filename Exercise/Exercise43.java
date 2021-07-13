package Exercise;

import java.util.Scanner;

public class Exercise43 {
	/*
	 * 사용자로부터 5과목의 점수를 입력받아 평균을 구하는 프로그램을 작성하여 보자. 평균 점수로 학점을 계산하여 출력한다.(평균 점수는 소숫점
	 * 둘째자리까지만 출력) 평균 점수가 90점 이상이면 A, 80점 이상 90점 미만이면 B, 70점 이상 80점 미만이면 C, 60점 이상
	 * 70점 미만이면 D, 60점 미만이면 F로 계산한다.
	 */
	//입력부분
	public static void main(String[] args) {

		
		Scanner scanner = new Scanner(System.in);
		System.out.println("점수를 입력하세요.");
		System.out.print("프로그래밍 기초: ");
		int pro = scanner.nextInt();
		System.out.print("데이터베이스: ");
		int db = scanner.nextInt();
		System.out.print("화면구현: ");
		int vi = scanner.nextInt();
		System.out.print("애플리케이션 구현: ");
		int app = scanner.nextInt();
		System.out.print("머신러닝: ");
		int mr = scanner.nextInt();
		
		System.out.println("총점: " );
		System.out.println("평균: " );
		System.out.println("학점: " );
		
		












//		System.out.println("점수를 입력하세요.");
//		System.out.print("프로그래밍 기초: ");
//		int num = scanner.nextInt();
//		System.out.print("데이터베이스: ");
//		int num2 = scanner.nextInt();
//		System.out.print("화면 구현: ");
//		int num3 = scanner.nextInt();
//		System.out.print("애플리케이션 구현: ");
//		int num4 = scanner.nextInt();
//		System.out.print("머닝러신: ");
//		int num5 = scanner.nextInt();
////데이터 처리부분
////총점		
//		int total = num + num2 + num3 + num4 + num5;
////평균
//		double average = total/5.0;
////학점	
//		String result ="";
//		System.out.print("학점: ");
//		if (average >= 90) {
//			result="A";
//		} else if (average < 90 && average >= 80) {
//			result="B";
//		} else if (average < 80 && average >= 70) {
//			result="C";
//		} else if (average < 70 && average >= 60) {
//			result="D";
//		} else {
//			result="F";
//			scanner.close();
//		}
//		System.out.println("총점: "+total );
//		System.out.println("평균: "+average );
//		System.out.println("학점: "+result );
	}

}
