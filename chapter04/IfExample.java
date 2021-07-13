package chapter04;

public class IfExample {

	public static void main(String[] args) {
		int score = 93;
		
		if (score>=90) {
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다.");
				
		}
		// 들여쓰기(Indent)
		// 자동 정렬 (ctrl + shift + f(formatting))
		if (score < 90) 
			System.out.println("점수가 90보다 작습니다.");
		  	System.out.println("등급은 B입니다.");
		
	}

}
