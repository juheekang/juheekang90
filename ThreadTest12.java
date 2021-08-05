package kr.or.ddit.basic;

/*
 	Thread의 stop()메소드를 호출하면 스레드가 바로 멈춘다.
 	이 때 사용하던 자원을 정리하지 못하고 프로그램이 종료되어
 	나중에 실행되는 프로그램에 영향을 줄수 있다.
 	그래서 stop()메소드는 비추천으로 되어있다.
 */

public class ThreadTest12 {

	public static void main(String[] args) {
		/*
		ThreadStopTest1 th1 =new ThreadStopTest1();
		th1.start();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		// th1.stop(); 	// 사용할수 있지만 비추천하는 메소드
		th1.setStop(true);
		*/
		
		// interrupt()메소드를 이용하 스레드 멈추기
		ThreadStopTest2 th2 = new ThreadStopTest2();
		th2.start();
		try {
			th2.sleep(500);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		th2.interrupt();
	}
}

// 스레드를 멈추게 하는 연습용 스레드
class ThreadStopTest1 extends Thread {
	private boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		while(!stop) {
			System.out.println("스레드 실행 중");
		// ... 스레드에서 할일 기술
		}
		System.out.println("자원 정리");
		System.out.println("스레드 종료");
	}
}

// interrupt()메소드를 이용하여 스레드를 멈추게 하는 방법
class ThreadStopTest2 extends Thread{
	@Override
	public void run() {
		/*
		// 방법 1 ==> interrupt()메소드와 sleep()메소드를 이용하는 방법
		try {
			while(true) {
				System.out.println("실행중");
				// ...
				// ...
				Thread.sleep(1);
			}
			
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		*/
		
		// 방법 2
		while(true) {
			System.out.println("Thread 실행중");
			//...
			//...
			// interrupt()메소드가 호출되었는지 검사한다.
			
			// 검사 방법 1 ==> Thread의 인스턴스 메소드인 isInterrupted()메소드를 이용하기
			//		isInterrupted()ㅔ메소드는 interrupt()메소드가 
			//호출되면 true를 반환한다.
			/*
			if(this.isInterrupted()) {
				break;
			}
			*/
			
			// 검사 방법 2 ==> Thread의 정적 메소드인 interrupted()메소드 이용하기
			//		interrupted()메소드도 interrupt()메소드가 호출되면 true를 반환한다.
			if(Thread.interrupted()) {
				break;
			}
			
		}
		
		System.out.println("자원정리");
		System.out.println("스레드 종료");
	}
}
