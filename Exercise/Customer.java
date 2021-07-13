package Exercise;

public class Customer {

	private String firstName;
	private String lastName;
	BankAccount account;
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}
	
	public String toString() {
		return "이름: " + firstName+" "+ lastName +", 잔고: " + account.getBalance();
//		return "이름: %s %s, 잔고: %d원", firstName,lastName, account.getBalance();
	}
	
}
