package Exercise;

public class BankAccount {
	//잔액
	private int balance;
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
	 * @return 이체성공시 true, 실패false
	 */
//	(이체)현재계좌에서 amount만큼을 다른계좌로 송금
	public boolean transfer(int amount, BankAccount otherAccount) {
		withdraw(amount);
		otherAccount.deposit(amount);
		return true;
	}
}
