package Exercise;

public class Bank {

	private Customer[] customers; // =null
	private int numberOfCustomers; // =0
	
	public Bank() {
		customers = new Customer[10];
	}
	
	public void addCustomer(Customer customer) {
		customers[numberOfCustomers++] = customer;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	public Customer getCustomer(int index) {
		return customers[index];
	}
}