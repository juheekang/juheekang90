package chapter10.exercise;

public abstract class BankAccount {
	//잔액
	protected int balance;
	protected String accountType;
	//생성자
	public BankAccount(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}
//	입금메소드
	public void deposit(int amount) {
		balance += amount;
	}
//	출금메소드
	public boolean withdraw(int amount) {
		balance -= amount;
		return true;	
	}
	/**
	 * 현재 계좌에서 다른계좌로 amount(금액)을 이체하는 메소드
	 * @param amount 이체금액
	 * @param otherAccount 이체할 계좌번호
	 */
//	(이체)현재계좌에서 amount만큼을 다른계좌로 송금
	public boolean transfer(int amount, BankAccount otherAccount) {
		if (amount <0 || amount > balance) {
			throw new IllegalArgumentException();
		}
		if (otherAccount == null) {
			throw new NullPointerException();
		}
		withdraw(amount);
		otherAccount.deposit(amount);
		return true;
	
	}		
	//추상클래스는 바디{}가 없음
	public  abstract String getAccountType();
	
	
	
	@Override
	public String toString() {
		return String.format("%,d", balance);
	}

	
}
