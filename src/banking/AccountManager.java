package banking;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager implements ICustomDefine{

	String BankNumber;
	String Name;
	int Money;
	
	public ArrayList<Account> account = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	public static void showMenu() { //메뉴출력
		System.out.println("-----Menu-----");
		System.out.println("1. 계좌개설");
		System.out.println("2. 입   금");
		System.out.println("3. 출   금");
		System.out.println("4. 전체계좌정보출력");
		System.out.println("5. 프로그램종료");
	}
	
public void makeAccount() {//계좌개설을 위한 함수
		
		
		System.out.println("***신규계좌개설***");		
		System.out.println("계좌번호 : ");
		BankNumber = AccountManager.sc.nextLine();
		System.out.println("고객이름 : ");
		Name = AccountManager.sc.nextLine();
		System.out.println("잔   고 : ");
		Money = AccountManager.sc.nextInt();
		System.out.println("계좌개설이 완료되었습니다.");
		
	}
	
	
	public void depositMoney() {//입  금
		
		System.out.println("계좌번호: ");
        String BankNumber = AccountManager.sc.nextLine();
        System.out.println("입금액: ");
        int Money = Integer.parseInt(AccountManager.sc.nextLine());
        AccountManager acc = new AccountManager();
        if (acc != null) {
            acc.depositMoney();
            System.out.println("입금 완료.");
        }else {
			System.out.println("계좌를 찾을수 없습니다.");
		}
	}
	
	public boolean withdrawMoney() {//출  금
		System.out.println("계좌번호: ");
		String BankNumber = AccountManager.sc.nextLine();
		System.out.println("출금액: ");
		
		AccountManager acc = new AccountManager();
		if (acc.withdrawMoney()) {
			System.out.println("출금이 완료되었습니다.");
		} else {
			System.out.println("잔액이 부족합니다.");
		}
		return false;
		
	}
	public void showAccInfo() { //전체계좌정보출력
		System.out.println("계좌번호: " + BankNumber);
        System.out.println("고객이름: " + Name);
        System.out.println("잔고: " + Money);
		System.out.println("***계좌정보출력***");
	}
}