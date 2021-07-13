package chapter05;

public class AdvancedForExample {

	public static void main(String[] args) {
		int[] scores = { 95, 70, 84, 93, 87 };
		
		int sum = 0;
//		원시
//		for (int i = 0; i < scores.length; i++) {
//			sum += scores[i];
//		}
//		classic
		for (int score : scores) {
			sum += score;
//		현재- stream
			
		}
		
	}

}
