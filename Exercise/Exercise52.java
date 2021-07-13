package Exercise;

import java.util.Random;

public class Exercise52 {

	public static void main(String[] args) {
//		로또번호를 생성하는 프로그램을 작성하시오.
//		(로또 번호는 1 ~ 45번까지 있으며 이 중에서 중복되지 않는 6개의 숫자를 추출하여 결과를 출력한다.)
		int[] lotto = new int[6];//6개의 숫자를 저장할 배열 생성
		Random random = new Random();
//		1.
		/*for (int i = 0; i < lotto.length; i++) {
			lotto[i]=random.nextInt(45) + 1; //1부터 45까지 랜덤 생성후 배열에 저장
					
			for (int j = 0; j < i; j++) {
				if(lotto[i]==lotto[j]) {
					i--;
					break;
				}		
			}
		}*/
		
//		2.
		int[] allLotto =new int[45];
		for(int i=0; i<45; i++) { //1~45까지 배열생성
			allLotto[i] = i+ 1;
		}
//		allLotto[0] <--> allLotto [random]
//		a<-->b
//		int temp = 0;
		
		for (int i = 0; i < allLotto.length; i++) {
			int ranNum = random.nextInt(45);
			int temp = allLotto[i];
			allLotto[i] = allLotto [ranNum];
			allLotto[ranNum] = temp;
		}
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = allLotto[i];
		}	
		for (int i = 0; i < lotto.length; i++) {
			System.out.println(lotto[i]+" ");
		//		for (int i = 0; i < lotto.length; i++) {
//		System.out.print(lotto[i] + " ");

		}
	}	
}
