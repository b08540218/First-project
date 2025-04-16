package banking;

abstract class Account {
	//계좌번호(String형), 이름(String형), 잔액(int형) 
	protected String accNum;
	protected String name;
	protected int balance;
	protected int interest;
//	private String grade2;
	
	//생성자
	public Account(String accNum, String name, int balance, int interest) {
		super();
		this.accNum = accNum;
		this.name = name;
		this.balance = balance;
		this.interest = interest;
//		this.grade2 = grade2;
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
//	public String getGrade() {
//		return grade2;
//	}
//	public void setGrade(String grade) {
//		this.grade2 = grade;
//	}
	
	
	//toString 오버라이딩

<<<<<<< HEAD
	
	@Override
	public String toString() {
		return "[계좌번호="+ accNum + 
				", 이름="+ name + 
				", 잔고=" + balance+ 
				", 이자율=" + interest +"%]";
	}
//	@Override
//	public String toString() {
//		return "[계좌번호="+ accNum + 
//				", 이름="+ name + 
//				", 잔고=" + balance+ 
//				", 이자율=" + interest +"%, "+
//				"신용등급:"+ grade2+ "]";
//	}


	public void deposit(int amount) { //입 금 이 자
		int creditRate = 0;
		int interest = (int)(balance * creditRate);
        balance = balance + interest + amount;
	}



	public void showAccountInfo() {//계좌정보 출력
		System.out.println("계좌번호: " + accNum);
        System.out.println("고객이름: " + name);
        System.out.println("잔고: " + balance);
	}
	
=======
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
>>>>>>> branch 'main' of https://github.com/b08540218/1-.git
}
