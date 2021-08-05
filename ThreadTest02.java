package kr.or.ddit.basic;

import java.util.List;

public class ThreadTest02 {

	// 메인 메서드도 스레드
	public static void main(String[] args) {
		// 멀티 쓰레드 프로그램
		// Thread를 사용하는 벙법

		// 방법1
		// Thread클래스를 상속한 class를 작성한 후 이 class의 인스턴스를 생성한 후
		// 이 인스턴스의 start()메서드를 메인메서드에서 호출해서 실행한다.
		MyThread1 th1 = new MyThread1();

//		start와 run 메소드는 자바에서 제공해주는 메소드이고 
//		이 메소드는 스레드 영역을 새로만들어서 런메소드를 호출해주고 스타드의 역할은 끝남
		th1.start();
//		run메소드를 호출했을때는 싱글스레드와 같은 방식으로 위에서부터 순차적으로 출력된다.
		
		// 방법2
		// Runnable 인터페이스를 구현한 class를 작성한 후 이 class의 인스턴스를 생성한 후
		// Thread객체를 생성할 때 Thread객체의 생성자에 넣어서 생성하고 이 Thread객체의
		// start() 메서드를 호출해서 실행한다.
		MyRunner runner = new MyRunner();
		Thread th2 = new Thread(runner);
		th2.start();
		
		
		
		// 방법 3  ==> 익명구현체 (클래스없이 인터페이스를 구현, 일회성 , 1개만 만들수있음)
		Runnable r = new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 200; i++) {
					System.out.print("@");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
				
			}
		};
		
		Thread th3 = new Thread(r);
//		th1.start();
//		th2.start(); //메인메서드가 먼저 출력되고 실행된다.
		th3.start();
		
		System.out.println("main 메서드 끝");
		
	}
}

//방법1
class MyThread1 extends Thread {
	@Override
	public void run() {
		// 이 run()메서드 안에 쓰레드에서 처리할 내용을 기술한다.
		for (int i = 1; i <= 200; i++) {
			System.out.print("*");
			try {
				// Thread.sleep(시간) 메서드는 주어진 시간동안 작업을 잠시 멈춘다.
				// 시간은 밀리세컨드(1/1000초) 단위를 사용한다.
				// 즉, 1000은 1초를 의미한다
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}

// 방법2
class MyRunner implements Runnable {
	@Override
	public void run() {
		// 이 run()메서드 안에 쓰레드에서 처리할 내용을 기술한다.
		for (int i = 1; i <= 200; i++) {
			System.out.print("$");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}
