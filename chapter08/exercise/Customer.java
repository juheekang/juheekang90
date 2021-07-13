package chapter08.exercise;

public class Customer {
	private String firstName;
	private String lastName;
	private BankAccount[] accounts;
	private int numberOfAccounts;

	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		accounts = new BankAccount[3];
	}
	

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void addAccount(BankAccount account) {
		accounts[numberOfAccounts++]= account;
	}
	
	public BankAccount getAccount(int index) {
		return accounts[index];
	}
	

	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}


	public String toString() {
		return String.format("%s %s", firstName, lastName);
//		return "이름: %s %s, 잔고: %d원", firstName,lastName, account.getBalance();
	}
	
}


