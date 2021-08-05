package kr.or.ddit.basic;

public class ThreadTest01 {

	public static void main(String[] args) {
		// *  , $
		// 싱글 쓰레드 프로그램 - 흐름이 하나뿐이다( 위에서부터 순차적으로 실행 )
		for(int i = 1; i<=200; i++) {
			System.out.println("*");
		}
		System.out.println();
		System.out.println();
		for (int i = 1; i <=200; i++) {
			System.out.println("$");
		}
	}

}
