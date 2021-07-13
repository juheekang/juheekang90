package chapter03;

import java.util.Scanner;

public class ConditionalOperationExample {

	public static void main(String[] args) {
/*		int score = 85;
		char grade = (score > 90) ? 'A' : ( (score > 80) ? 'B' : 'C');
		System.out.println(score + "점은" + grade + "등급입니다.");*/

		
//		chapter 03-2-2
		/*byte b = 5;
		b = -b;
		int result = 10/b;
		System.out.println(result);*/
		
//		chapter 03-2-3
//		boolean stop = true;
//		while(!stop) {
			
//		}
		
		

/*		chapter 03-2-4 		
		int pencils = 534;
		int students = 30;
		
//		학생 1명이 가지는 연필개수
		int pencilsPerStudent = (pencils/students);
		System.out.println(pencilsPerStudent);
		
//		남은연필개수
		int pencilsLeft = (pencils%students);
		System.out.println(pencilsLeft);
*/				
/*		chapter 03-2-5
    	int var1 = 5;
        int var2 = 2;
        double var3 = (double)var1 / var2;
        int var4 = (int) (var3* var2);
        System.out.println(var4);	
 */
		
//	    chapter 03-2-6
		/*int value = 356;
		System.out.println((value/100)*100);*/
		
		
//		chapter 03-2-7
		/*		float var1 = 10f;
		double var2 = (double) var1 / 100;
		if(var2 == 0.1) {
			System.out.println("10%입니다.");
		}else {
			System.out.println("10%가 아닙니다.");
		}*/
//		chapter 03-2-8
//		int lengthTop = 5;
//		int lengthBottom = 10;
//		int height = 7;
//		double area = (((double)lengthTop+lengthBottom)/2*height);
//		System.out.println(area);

//		chapter 03-2-9 
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 수: ");
		double num1 = scanner.nextDouble();
		System.out.print("두번째 수: ");
		double num2 = scanner.nextDouble();
		System.out.println("-----------------");
		if (num2 == 0.0) {
			System.out.println("결과: 무한대");
		}else {
			double result = num1/num2;
			System.out.println("결과: "+ result);
		}
		scanner.close();
		
		
//		chapter 03-2-10 		
//		int var1 = 10;
//		int var2 = 3;
//		int var3 = 14;
//		double var4 = (var1* var1) * Double.parseDouble(var2+ "."+ var3);
//		System.out.println("원의 넓이:"+ var4);
		
		
//		chapter 03-2-11 			
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("아이디:");
//		String name = scanner.nextLine();
//		
//		System.out.print("패스워드:");
//		String strPassword = scanner.nextLine();
//		int password = Integer.parseInt(strPassword);
//		
//		if(name.equals("java")) {
//			if(password == 12345) {
//				System.out.println("로그인 성공");
//			} else {
//				System.out.println("로그인 실패:패스워드가 틀림");
//			}
//		} else {
//			System.out.println("로그인 실패:아이디 존재하지 않음");
//		} 
		
	}

}
