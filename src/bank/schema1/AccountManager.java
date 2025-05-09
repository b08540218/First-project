package bank.schema1;

import java.util.Scanner;

public class AccountManager {

	//키보드 입력을 위한 인스턴스
		static Scanner scan = new Scanner(System.in);
		//계좌정보 저장을 위한 인스턴스배열
		static Account[] accounts = new Account[50];
		//개설된 계좌정보 카운트용 변수
		static int accCnt = 0;
		
	public static void showMenu() {
		System.out.println("1. 계좌계설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 전체계좌정보출력");
		System.out.println("5. 프로그램종료");
	}
	
	// 계좌개설을 위한 함수
	public static void makeAccount() {
//		System.out.println("1. 보통예금계좌  2. 신용신뢰계좌");
//		int choice =Integer.parseInt(scan.nextLine());
		
		System.out.print("계좌번호: ");
		String a = scan.nextLine();
		System.out.print("이름: ");
		String n = scan.nextLine();
		System.out.print("잔고: ");
		int b = scan.nextInt();
		
		//신규계좌 생성 및 추가
		Account ac = new Account(a, n, b);
		accounts[accCnt++] = ac;
		System.out.println("신규계좌 개설 완료");
	}
	
	
	// 입    금
	public static void depositMoney()  {
		System.out.print("계좌번호: ");
		String a= scan.nextLine();
		System.out.print("입금액: ");
		int d = scan.nextInt();
		findAccount(a).setBalance(findAccount(a).getBalance() + d);
		System.out.println("예금이 성공되었습니다.");
	}
	
	
	// 출    금
	public static void withdrawMoney() {
		System.out.print("계좌번호: ");
		String a= scan.nextLine();
		System.out.print("출금액: ");
		int d = scan.nextInt();
		int remain = findAccount(a).getBalance() - d;
		if (remain < 0) {
			System.out.println("출금 가능액을 초과하였습니다.");
		} else {
			findAccount(a).setBalance(remain);
			System.out.println("출금이 성공되었습니다.");
		}
	}
	
	// 전체계좌정보출력
	public static void showAccInfo() {
		for(int i=0 ; i<accCnt; i++) {
			//toString을 오버라이딩 했으므로 인스턴스를 그대로 출력
			System.out.println(accounts[i]);
		}
		System.out.println("*전체계좌정보가 출력됨*");
	}
	
	private static Account findAccount(String accNum) {
		for (int i=0; i< accCnt; i++) {
			if (accounts[i].getAccNum().equals(accNum)) {
				return accounts[i];
			}
		}
		System.out.println("해당 계좌를 찾을 수 없습니다.");
		return null;
	}
}
