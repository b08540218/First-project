package bank.schema5;

import java.io.Serializable;

abstract class Account implements Serializable{
	
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
	
	@Override
	public String toString() {
		return "[계좌번호="+ accNum + 
				", 이름="+ name + 
				", 잔고=" + balance+ 
				", 이자율=" + interest +"%, ";
	}
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
	
}
