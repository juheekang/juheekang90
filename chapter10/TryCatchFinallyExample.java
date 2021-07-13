package chapter10;

public class TryCatchFinallyExample {

	public static void main(String[] args) {
		try {
			Class.forName("java.land.String");
		} catch (ClassNotFoundException e) {
			//쌓인 에러를 아래부터 출력
//			e.printStackTrace();
			System.out.println("클래스가 존재하지 않습니다.");
		}{
			
		}
	}

}
