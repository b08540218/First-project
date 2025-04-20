package bank.schema6;

/*
보통예금계좌 > 최소한의 이자를 지급하는 자율 입출금식 계좌
생성자를 통해서 이율정보(이자비율의정보)를 초기화 할수있도록 정의한다.

 */
public class NormalAccount extends Account{
	
public NormalAccount(String accNum, String name, int balance, int interest) {
		super(accNum, name, balance, interest);
	}

	@Override
	public void deposit(int amount) {
		//단순 이자 계산을 포함해서 잔고에 반영한다.
		balance += amount + (amount * interest / 100);
	}
	
	@Override
	public void showAccountInfo() {
		//이자율 정보 출력
		System.out.println("이자율%: "+  interest + "%");
		System.out.println("----------------------------");
	}
}
