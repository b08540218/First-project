package banking;

import java.util.Scanner;

public class BankingSystemMain {
	public static void main(String[] args) {
		AccountManager manager = new AccountManager();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			try {
				manager.showMenu();
				System.out.println("선택: ");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch (choice) {
				case ICustomDefine.MAKE:
					manager.createAccount();
					break;
				case ICustomDefine.DEPOSIT:
					manager.depositMoney();
					break;
				case ICustomDefine.WITHDRAW:
					manager.withdrawMoney();
					break;
				case ICustomDefine.INQUIRE:
					manager.showAllAccounts();
					break;
				case ICustomDefine.EXIT:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					throw new MenuSelectException("1~5 사이의 숫자만 입력해 주세요.");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요.");
			} catch (MenuSelectException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
