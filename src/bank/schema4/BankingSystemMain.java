package bank.schema4;

import java.util.InputMismatchException;

public class BankingSystemMain {
	
	
	public static void main(String[] args){
		while(true) {
			//메뉴출력
			try {
			AccountManager.showMenu();
			System.out.print("메뉴입력: ");
			
//			AccountManager.scan.nextLine();//버퍼에 남은 엔터키 제거
			
			String input = AccountManager.scan.nextLine();
			if (!input.matches("[0-9]+")) {
				throw new InputMismatchException("숫자만 입력 가능합니다.");
			}
			
			int key = Integer.parseInt(input);
			
			if (key < ICustomDefine.MAKE || key > ICustomDefine.EXIT) {
				throw new MenuSelectException("메뉴는 1~6 사이의 숫자만 입력 가능합니다.");
			}
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
				//계좌정보삭제
			case ICustomDefine.DELETE:
				System.out.println("계좌정보삭제");
				AccountManager.deleteAccount();
				break;
				//프로그램종료
			case ICustomDefine.EXIT:
//				return;
				System.exit(0);
				break;
			}//swith 끝
			}catch (MenuSelectException e) {
				System.out.println("※ 예외: "+ e.getMessage());
			}catch (InputMismatchException e) {
				System.out.println("※ 예외: 숫자만 입력해주세요.");
			}catch (Exception e) {
				System.out.println("※ 예외 발생: "+ e.getMessage());
			}
			System.out.println();
		}//while 끝
	}//main끝
}//class끝
