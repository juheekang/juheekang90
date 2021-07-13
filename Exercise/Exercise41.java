package Exercise;

import java.util.Scanner;

public class Exercise41 {

	public static void main(String[] args) {
		/*사용자로부터 세 변의 길이를 입력받은 후, 입력받은 변의 길이로 삼각형을 입력 받을 수 있는지 
		 * 판별하는 프로그램을 만들어 보자. 
		 * 삼각형을 판별하는 방법은 가장 긴 변의 길이가 
		 * 다른 두 변의 길이의 합보다 작으면 삼각형을 만들 수 있다.
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("삼각형의 첫번째 변의길이를 입력하세요: ");
		int tri1 = scanner.nextInt();
		System.out.print("삼각형의 두번째 변의길이를 입력하세요: ");
		int tri2 = scanner.nextInt();
		System.out.print("삼각형의 세번째 변의길이를 입력하세요: ");
		int tri3 = scanner.nextInt();
		if(tri1+tri2>tri3 && tri2+tri3>tri1 && tri1+tri3>tri2) {
			System.out.println("삼각형을 만들수 있습니다.");
		}else {
			System.out.println("삼각형을 만들수 없습니다.");
		}
		
		
		
		
		
		
		
		//		System.out.print("삼각형의 첫번째 변의 길이를 입력하세요: ");
//		int num1 = scanner.nextInt();
//		System.out.print("삼각형의 두번째 변의 길이를 입력하세요: ");	
//		int num2 = scanner.nextInt();
//		System.out.print("삼각형의 세번째 변의 길이를 입력하세요: ");
//		int num3 = scanner.nextInt();
//		
//		if((num1+num2)>num3 && (num2+num3)>num1 && (num1+num3)>num2) {
//			System.out.println("삼각형을 만들 수 있습니다.");
//		} else {
//			System.out.println("삼각형을 만들 수 없습니다.");
//		}

		scanner.close();
	}

}
