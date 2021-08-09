package kr.or.ddit.basic;

public class ThreadTest03 {

	public static void main(String[] args) {
		//Thread가 수행되는 시간 체크해 보기
		Thread th = new Thread(new SumRunner());
		
		// 1970년 1월1일 0시0분0초(표준시간)부터 현재까지 경과한 시간을 
		// 밀리세컨드(1/1000초)단위로 반환한다.
		long startTime = System.currentTimeMillis();
		
		th.start();   //스레드 실행
		
		try {
			th.join();	// 현재 실행중(메인스레드)인 스레드에서 대상이 되는 스레드(변수 th)가
						// 종료될때까지 기다린다.
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("경과시간 : " + (endTime - startTime));
	}

}


class SumRunner implements Runnable{
	@Override
	public void run() {
		//합계구하는 스레드
		long sum = 0L;
		for(long i=1L; i<=1_000_000_000; i++) {
			sum += i;
		}
		System.out.println("합계 : " + sum);
	}
}