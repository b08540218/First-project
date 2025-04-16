package banking;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager implements ICustomDefine{
	private ArrayList<Account> accounts = new ArrayList<Account>();
	private Scanner sc = new Scanner(System.in);
	
	public void showMenu()	{
		System.out.println("-----Menu-----");
        System.out.println("1. 계좌개설");
        System.out.println("2. 입금");
        System.out.println("3. 출금");
        System.out.println("4. 전체계좌정보출력");
        System.out.println("5. 프로그램종료");
	}
	
	public void createAccount() {
		System.out.println("1. 보통계좌 2. 신용신뢰계좌");
		int choice = Integer.parseInt(sc.nextLine());
		
		System.out.print("계좌번호: ");
        String accNo = sc.nextLine();
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("잔액: ");
        int balance = Integer.parseInt(sc.nextLine());
        System.out.print("이자율%: ");
        int interest = Integer.parseInt(sc.nextLine());
        
        if (choice == 1) {
        	accounts.add(new NormalAccount(accNo, name, balance, interest));
        }else {
			System.out.println("신용듭급(A, B, C): ");
			String grade = sc.nextLine().toUpperCase();
			int creditRate = 0;
			switch (grade) {
			case "A":
				creditRate = A;
				break;
			case "B":
				creditRate = B;
				break;
			case "C":
				creditRate = C;
				break;
			}
			accounts.add(new HighCreditAccount(accNo, name, balance, interest, creditRate));
			System.out.println("계좌가 개설되었습니다.");
		}
	}
	
	public void depositMoney() {
		System.out.print("계좌번호: ");
        String accNo = sc.nextLine();
        System.out.print("입금액: ");
        int amount = Integer.parseInt(sc.nextLine());

        Account acc = findAccount(accNo);
        if (acc != null) {
			acc.deposit(amount);
			System.out.println("입금 완료.");
		} else {
			System.out.println("계좌를 찾을 수 없습니다.");
		}
	}
	public void withdrawMoney() {
		System.out.print("계좌번호: ");
		String accNo = sc.nextLine();
		System.out.print("출금액: ");
		int amount = Integer.parseInt(sc.nextLine());
		
		Account acc= findAccount(accNo);
		if (acc != null) {
			if (acc.withdraw(amount)) {
				System.out.println("출금 완료");
			} else {
				System.out.println("잔액 부족.");
			}
		} else {
			System.out.println("계좌를 찾을 수 없습니다.");
		}
	}
	
	public void showAllAccounts() {
		for (Account acc : accounts) {
			acc.showAccountInfo();
		}
	}
	private Account findAccount(String accNo) {
		for (Account acc : accounts) {
			if (acc.getAccountNumber().equals(accNo)) {
				return acc;
			}
		}
		return null;
	}
}















