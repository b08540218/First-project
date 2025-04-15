package bank.schema3;

/*
보통예금계좌 > 최소한의 이자를 지급하는 자율 입출금식 계좌
생성자를 통해서 이율정보(이자비율의정보)를 초기화 할수있도록 정의한다.

 */
public class NormalAccount extends Account{
	private int interestRate;

	public NormalAccount(String accNum, String name, int balance, int interestRate) {
		super(accNum, name, balance, interestRate);
		this.interestRate = interestRate;
	}
	@Override
	public void deposit(int amount) {
		balance += amount + (amount * interestRate / 100);
	}
	@Override
	public void showAccountInfo() {
		System.out.println("이자율%: "+  interestRate + "%");
		System.out.println("----------------------------");
	}
}

