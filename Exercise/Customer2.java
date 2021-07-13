package Exercise;

public class Customer2 {
	private String firstName;
	private String lastName;
	private BankAccount2[] accounts;
	private int numberOfAccounts;

	
	public Customer2(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		accounts = new BankAccount2[5];
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
	
	public void addAccount(BankAccount2 account) {
		accounts[numberOfAccounts++]= account;
	}
	
	public BankAccount2 getAccount2(int index) {
		return accounts[index];
	}
	

	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}


	public String toString() {
		return String.format("이름: %s %s, 계좌의 갯수: %d", firstName, lastName, getNumberOfAccounts());
//		return "이름: %s %s, 잔고: %d원", firstName,lastName, account.getBalance();
	}
	
}


