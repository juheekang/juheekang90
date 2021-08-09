package kr.or.ddit.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//은행의 입출금을 스레드로 처리하는 예제

//(Lock 객체를 이용한 동기화 처리 예제)

public class ThreadTest18 {
	private int balance; // 잔액이 저장될 변수

	// Lock객체 생성 => 되도록이면 private final로 만든다. lock을 관리하는 객체가 여러개이면 안됌
	private final Lock lock = new ReentrantLock();

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	// 입금처리를 하는 메소드
	public void deposit(int money) {
		// Lock객체는 lock()메소드로 락을 설정하고,
		// unlock()메소드로 반드시 락을 해제한다.
		lock.lock(); // 락설정 시작
		balance += money;
		lock.unlock(); // 락을 해제해준다.
	}

	// 출금처리를 하는 메소드 (반환값 ==> 성공 : true, 실패 : false)
	public boolean withdraw(int money) {
		lock.lock();

		// 만약에 try- catch블럭이 사용되는부분에서(try- catch블럭은 없어도 무관) 
		// unlock()메서드를 호출할때는 finally영역에서 호출하는것이 안전하다.

		boolean chk = false;
		try {  ////
			if (balance >= money) {
				for (int i = 1; i <= 100000000; i++) { } // 시간 지연용 제어가 다른스레드로 넘어갈수있게 하기위한 시간 지연용
				balance -= money;
				System.out.println("메소드 안에서 balance =" + balance);
				chk = true;
			} else {
				chk = false;
			}
		} catch (Exception e) {  ////
		} finally {  ////
			lock.unlock();
		}  ////
		return chk;

	}

	public static void main(String[] args) {
		ThreadTest18 acount = new ThreadTest18();
		acount.setBalance(10000); // 잔액을 10000원으로 설정

		// 익명구현체로 스레드 구현
		Runnable test = new Runnable() {

			@Override
			public void run() {
				boolean result = acount.withdraw(6000); // 6000원 출금하기
				System.out.println("스레드에서 result = " + result + ", balance = " + acount.getBalance());
			}
		};

		Thread th1 = new Thread(test);
		Thread th2 = new Thread(test);

		th1.start();
		th2.start();

	}

}
