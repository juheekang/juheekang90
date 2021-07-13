package Exercise;

import java.util.Scanner;

public class Exercise24 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("원기둥 밑변의 반지름을 입력하시오.(단위: cm):");
		double input = scanner.nextDouble();
		System.out.print("원기둥의 높이를 입력하시오.(단위: cm):");
		double input2 = scanner.nextDouble();
		System.out.print("원기둥 밑변의 넓이는"+(Math.PI*input*input)+"㎠ 이고,");
		System.out.print("원기둥의 부피는 "+(Math.PI*input*input*input2)+ "㎤ 이다." );
		
		scanner.close();
	}

}
