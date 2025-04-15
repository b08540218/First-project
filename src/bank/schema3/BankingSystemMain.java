package bank.schema3;

public class BankingSystemMain {
	
	
	public static void main(String[] args) {
		
		while(true) {
		//메뉴출력
			AccountManager.showMenu();
			System.out.print("메뉴입력: ");
			int key = AccountManager.scan.nextInt();
			AccountManager.scan.nextLine();//버퍼에 남은 엔터키 제거
			
			switch (key) {
			case ICustomDefine.MAKE:
				//계좌개설
				System.out.println("계좌개설");
				AccountManager.makeAccount();
				break;
			case ICustomDefine.DEPOSIT:
				//입금
				System.out.println("입금");
				AccountManager.depositMoney();
				break;
			case ICustomDefine.WITHDRAW:
				//출금
				System.out.println("출금");
				AccountManager.withdrawMoney();
				break;
			case ICustomDefine.INQUIRE:
				//계좌정보출력
				System.out.println("계좌정보출력");
				AccountManager.showAccInfo();
				break;
			case ICustomDefine.EXIT:
				//프로그램종료
				System.exit(0);
				
				break;
			}//swith 끝
		}//while 끝
	}//main끝
}//class끝
