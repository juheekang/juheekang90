package kr.or.ddit.basic;
// 은행의 입출금을 스레드로 처리하는 예제
// (synchronized를 이용한 동기화 처리 예제)


public class ThreadTest17 {
	private int balance;	//잔액이 저장될 변수
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//입금처리를 하는 메소드
	public void deposit(int money) {
		balance += money;
	}
	
	// 출금처리를 하는 메소드 (반환값 ==> 성공 : true, 실패 : false)
	public synchronized boolean withdraw(int money) {
		if(balance >= money) {
			for (int i = 1; i <= 100000000; i++) {} //시간 지연용 제어가 다른스레드로 넘어갈수있게 하기위한 시간 지연용
			balance -= money;
			System.out.println("메소드 안에서 balance =" + balance);
			return true;
			} else {
				return false;
		}
	}
	
	public static void main(String[] args) {

			ThreadTest17 acount = new ThreadTest17();
			acount.setBalance(10000);	// 잔액을 10000원으로 설정
			
			//익명구현체로 스레드 구현
			Runnable test = new Runnable() {
				
				@Override
				public void run() {
					boolean result = acount.withdraw(6000);	//6000원 출금하기
					System.out.println("스레드에서 result = "+ result + ", balance = " + acount.getBalance());
				}
			};
			
			Thread th1 = new Thread(test);
			Thread th2 = new Thread(test);
			
			th1.start();
			th2.start();
	}

}
