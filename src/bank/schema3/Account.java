package bank.schema3;

abstract class Account {
	//계좌번호(String형), 이름(String형), 잔액(int형) 
	protected String accNum;
	protected String name;
	protected int balance;
	protected int interest;
	
	//생성자
	public Account(String accNum, String name, int balance, int interest) {
		super();
		this.accNum = accNum;
		this.name = name;
		this.balance = balance;
		this.interest = interest;
	}
	
	
	
	//게터/세터
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getInterest() {
		return interest;
	}
	public void setInterest(int interest) {
		this.interest = interest;
	}
	
	
	//toString 오버라이딩

	@Override
	public String toString() {
		return "Account [accNum(계좌번호)=" + accNum + ", name(이름)=" + name + ", balance(잔고)=" + balance + ", interest(이자율)=" + interest + "]";
	}

//	 private static final double BASIC_INTEREST_RATE = 0.01;

	public void deposit(int amount) {
		int creditRate = 0;
		int interest = (int)(balance * creditRate);
        balance = balance + interest + amount;
	}



	public void showAccountInfo() {
		System.out.println("계좌번호: " + accNum);
        System.out.println("고객이름: " + name);
        System.out.println("잔고: " + balance);
	}
	
}
