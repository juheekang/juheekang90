package kr.or.ddit.basic;

/*
   1~20억까지의 합계를 구하는 프로그램을 하나의 스레드가 단독으로 처리했을때와
   여러개의 스레드가 협력해서 처리할때의 경과시간을 비교해 보자.
 */

public class ThreadTest04 {

	public static void main(String[] args) {
		// 단독으로 처리하기
		SumThread sm = new SumThread(1, 2_000_000_000L);
		long startTime = System.currentTimeMillis();
		sm.start();
		try {
			sm.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println("단독으로 처리했을 때의 경과시간 : " + (endTime - startTime));
		System.out.println("-----------------------------------------------");

		// 여러 스레드가 협력해서 처리하기 1개의 스레드가 5억씩 담당
		SumThread[] smArr = new SumThread[] {
				new SumThread(			  1L,   500_000_000L),
				new SumThread(	500_000_001L, 1_000_000_000L),
				new SumThread(1_000_000_001L, 1_500_000_000L),
				new SumThread(1_500_000_001L, 2_000_000_000L),
		};
		
		startTime = System.currentTimeMillis();
		for (SumThread smth : smArr) {
			smth.start();
		}
		
		for (int i = 0; i < smArr.length; i++) {
			try {
				smArr[i].join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		endTime = System.currentTimeMillis();
		
		System.out.println("협력해서 처리했을 때의 경과시간 : "+ (endTime - startTime));
		
	}

}

// 합계를 구하느 스레드

class SumThread extends Thread{
	// 합계를 구할 영역의 시작값과 종료값이 저장될 변수 선언
	private long startNum, endNum;
	
	// 생성자에서 시작값과 종료값 셋팅하기
	public SumThread(long startNum, long endNnum) {
		this.startNum = startNum;
		this.endNum = endNnum;
	}
	
	@Override
	public void run() {
		long sum = 0L;
		for (long i = startNum; i < endNum; i++) {
			sum+= i;
		}
		System.out.println(startNum + "부터" + endNum + "까지의 합계 : " + sum);
	}
	
}