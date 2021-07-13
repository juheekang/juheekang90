package chapter10.exercise;

public class CheckingAccount extends BankAccount {
	SavingsAccount protectedBy;
	
	public CheckingAccount(int balance) {
		super(balance);
	}

	public CheckingAccount(int balance, SavingsAccount protectedBy) {
		super(balance);
		this.protectedBy = protectedBy;
	}
//amo=신용
//che= bal
//sav			
@Override
	public boolean withdraw(int amount) {
		if (amount > balance) {
			protectedBy.balance -= amount-balance;
			balance = 0;
		}else {
			super.withdraw(amount);
		}
		return true;
	}	
	public String getAccountType() {	
			return "당좌예금";
	}
	
}
