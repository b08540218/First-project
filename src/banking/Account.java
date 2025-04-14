package banking;


public abstract class Account {
	protected String accountNumber;
    protected String ownerName;
    protected int balance;

    public Account(String accountNumber, String ownerName, int balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public abstract void deposit(int amount);

    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void showAccountInfo() {
        System.out.println("계좌번호: " + accountNumber);
        System.out.println("고객이름: " + ownerName);
        System.out.println("잔고: " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

