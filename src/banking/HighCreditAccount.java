package banking;

public class HighCreditAccount {
	private int creditRate;
	
	public HighCreditAccount(String accountNumber, String ownerName, int balance, int interestRate, int creditRate) {
        super(accountNumber, ownerName, balance, interestRate);
        this.creditRate = creditRate;
    }

	@Override
	public void deposit(int amount) {
		int base = amount * creditRate / 100;
		super.deposit(amount + base);
	}

	@Override
	public void showAccountInfo() {
		super.showAccountInfo();
		System.out.println("신용등급 이률: "+ creditRate + "%");
		System.out.println("-------------------------------");
	}
}
