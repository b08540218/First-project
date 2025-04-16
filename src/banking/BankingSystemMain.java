package banking;

<<<<<<< HEAD
import java.util.InputMismatchException;
=======
import java.util.Scanner;
>>>>>>> branch 'main' of https://github.com/b08540218/1-.git

<<<<<<< HEAD
import bank.schema4.AccountManager;
import bank.schema4.ICustomDefine;
import bank.schema4.MenuSelectException;

public class BankingSystemMain {
	
	
	public static void main(String[] args){
		while(true) {
			//메뉴출력
=======
public class BankingSystemMain {
	public static void main(String[] args) {
		AccountManager manager = new AccountManager();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
>>>>>>> branch 'main' of https://github.com/b08540218/1-.git
			try {
<<<<<<< HEAD
			AccountManager.showMenu();
			System.out.print("메뉴입력: ");
//			int key = AccountManager.scan.nextInt();
			
//			AccountManager.scan.nextLine();//버퍼에 남은 엔터키 제거
			
			String input = AccountManager.scan.nextLine();
			if (!input.matches("[0-9]+")) {
				throw new InputMismatchException("숫자만 입력 가능합니다.");
=======
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
>>>>>>> branch 'main' of https://github.com/b08540218/1-.git
			}
<<<<<<< HEAD
			
			int key = Integer.parseInt(input);
			
			if (key < ICustomDefine.MAKE || key > ICustomDefine.EXIT) {
				throw new MenuSelectException("메뉴는 1~5 사이의 숫자만 입력 가능합니다.");
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
			case ICustomDefine.EXIT:
				//프로그램종료
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
=======
		}
	}
}
>>>>>>> branch 'main' of https://github.com/b08540218/1-.git
