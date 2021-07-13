package Exercise;

import java.util.Random;
import java.util.Scanner;

public class Exercise45 {

	public static void main(String[] args) {
		/*Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int x=0;
        int y=0;
        y = random.nextInt(100)+1;
       
        do {
        	System.out.println("1부터 100 사이의 정수 중 하나를 선택하세요: ");
        	 x = scanner.nextInt();
        	if(x>y) {
        		System.out.println("정답은 더 작은 수 입니다.");
        	} else if (x<y) {
        		System.out.println("정답은 더 큰 수 입니다.");
        	} else {
        		System.out.println("정답입니다. \n게임을 종료합니다.");
        	}
        } while(x!=y);*/
		
		Random random = new Random();
		int ranNum = random.nextInt(100)+1;
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		while (true) {
			System.out.println("1부터 100 사이의 정수 중 하나를 선택하세요: ");
			int inputNum = scanner.nextInt();
			count++;
			if (ranNum > inputNum) {
				System.out.println("정답은  더 큰수입니다.");
			} else if (ranNum < inputNum) {
				System.out.println("정답은  더 작은수입니다.");
			} else {
				System.out.println("정답입니다.");
				break;
			} 
		}
		
		System.out.println(count + "번 만에 맞추셨습니다!");
		System.out.println("게임을 종료합니다.");	
		
		
		scanner.close();
	}
}
