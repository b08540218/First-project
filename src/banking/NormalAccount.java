package banking;

public class NormalAccount extends Account{
	private int interestRate;
	
	 public NormalAccount(String accountNumber, String ownerName, int balance, int interestRate) {
	        super(accountNumber, ownerName, balance);
	        this.interestRate = interestRate;
	    }

	@Override
	public void deposit(int amount) {
		balance += amount + (amount * interestRate / 100);
	}

	@Override
	public void showAccountInfo() {
		super.showAccountInfo();
		System.out.println("이자율: "+  interestRate + "%");
		System.out.println("----------------------------");
	}
	
	 
	 
}
