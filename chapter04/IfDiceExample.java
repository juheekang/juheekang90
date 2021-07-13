package chapter04;

import java.util.Random;

public class IfDiceExample {

	public static void main(String[] args) {
		// 1. 난수표(random table) 공식 - 랜덤 수 구하기
		//n=>6, n: 몇개를 추출하느냐
//		int num = (int)(Math.random()*6) + 1;

		// 2. 최근에 많이 사용해야할 랜덤 생성 방법
		Random random = new Random(77);
		//bound: 몇개를 추출하느냐
		//0~5까지 6개를 추출
		int num = random.nextInt(6) + 1;
		System.out.println(num + "번이 나왔습니다.");
		num = random.nextInt(6) + 1;
		System.out.println(num + "번이 나왔습니다.");
		num = random.nextInt(6) + 1;
		System.out.println(num + "번이 나왔습니다.");
		num = random.nextInt(6) + 1;
		System.out.println(num + "번이 나왔습니다.");
		num = random.nextInt(6) + 1;
		System.out.println(num + "번이 나왔습니다.");
		num = random.nextInt(6) + 1;
	}

}
