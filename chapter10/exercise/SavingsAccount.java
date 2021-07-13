package chapter10.exercise;
//디폴트 생성자 없으면 SavingsAccount 에러가난다
public class SavingsAccount extends BankAccount{

	private double interestRate;

	public SavingsAccount(int balance, double interestRate) {
		super(balance);
		this.interestRate = interestRate;
	}
	public void updateBalance(int period) {
		balance += balance * interestRate * period;
	}
	public String getAccountType() {	
		return "저축예금";
}
}
