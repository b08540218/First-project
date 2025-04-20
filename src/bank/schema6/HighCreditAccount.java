package bank.schema6;

/*
신용신뢰계좌 > 신용도가 높은 고객에게 개설이 허용되며 높은 이율의 계좌이다.
NormalAccount 와 마찬가지로 생성자를 통해서 이율정보(이자비율의정보)를 
초기화 할수있도록 정의한다.
고객의 신용등급을 A, B, C로 나누고 계좌개설시 이 정보를 등록한다.
A,B,C 등급별로 각각 기본이율에 7%, 4%, 2%의 이율을 추가로 제공한다.

 */
public class HighCreditAccount extends Account{
		//신용등급에 따라 적용되는 추가 이율
		private int creditRate;
		private String grade;
	
	
		public HighCreditAccount(String accNum, String name, int balance, int interest, String grade) {
				super(accNum, name, balance, interest);
				this.grade = grade;
				
				//신용등급에 따라 추가 이율 지정, 인터페이스 ICustomDefine(인터페이스)의 상수를 사용
				if (grade.equals("A")) this.creditRate = ICustomDefine.A;
				else if (grade.equals("B")) this.creditRate = ICustomDefine.B;
				else if (grade.equals("C")) this.creditRate = ICustomDefine.C;
			}
		
		//신용계좌 : 잔고 + (잔고 * 기본이자) + (잔고 * 추가이자) + 입금액
		@Override
		public void deposit(int amount) {
			//기본 이자 계산
		    int baseInterest = (int)(balance * interest);
		    
		    //신용등급에 따른 추가 이자 계산
		    int extraInterest = (int)(balance * creditRate); 
		    
		    //최종 잔고계산식: 기존 잔고 + 기본이자 + 추가이자 + 입금액
		    int total = balance + baseInterest + extraInterest + amount;
		    
		    // 새로운 잔고에 반영
		    balance = total;
		}
		@Override
		public String toString() {
			return super.toString()+", 신용등급=" + grade ;
		}
		
		@Override
		public void showAccountInfo() {
			super.showAccountInfo();
			System.out.println("신용등급 이률: "+ creditRate + "%");
			System.out.println("신용등급: "+ grade);
			System.out.println("-------------------------------");
		}
		
		
}
