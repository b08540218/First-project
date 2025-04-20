package bank.schema6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class AccountManager implements ICustomDefine{
	
	// 계좌 정보 파일 이름
	private static final String FILE_NAME = "AcccountInfo.obj";
	//자동 저장을 위한 텍스트 파일 이름
	private static final String TEXT_FILE_NAME = "AutoSaveAccount.txt";
	//자동 저장 기능을 위한 AutoSaver 객체
	private static AutoSaver autoSaver;
	
	//키보드 입력을 위한 인스턴스
	static Scanner scan = new Scanner(System.in);
	//계좌정보 저장하는 HashSets 
	static Set<Account> account = new HashSet<>();
	
	//계좌 정보를 불어오는 함수
	@SuppressWarnings("unchecked")
	public static void loadAccountInfo() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
			//파일에서 계좌 정보를 불러옴
			account = (HashSet<Account>) ois.readObject();
			
			if (account.isEmpty()) {
				System.out.println("저장된 계좌 정보가 없습니다.");
				System.out.println("새로 시작합니다.");
			}else {
			System.out.println("이전에 저장된 계좌정보를 불러왔습니다.");
			}
		} catch (Exception e) {
			//예외가 발생하면 새로 시작
			System.out.println("저장된 계좌 정보가 없습니다.");
			System.out.println("새로 시작합니다.");
		}
	}
	//계좌 정보를 저장하는 함수
	public static void saveAccountInfo() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
			//계좌 정보를 파일에 저장
			oos.writeObject(account);
			System.out.println("AcccountInfo.obj 파일로 저장되었습니다.");
		} catch (IOException e) {
			System.out.println("계좌 정보를 저장하는대 실패했습니다.");
			e.printStackTrace();
		}
	}
	//자동 저장 기능을 설정하는 메뉴
	public static void AutoSaveMenu() {
		System.out.println("==========저장 옵션=============");
		System.out.println("1. 자동저장 ON ");
		System.out.println("2. 자동저장 OFF ");
		String input = scan.nextLine();
		if (input.equals("1")) {
			if (autoSaver != null && autoSaver.isAlive()) { //경고메세지 출력
				System.out.println("이미 자동저장이 실행중입니다.");
			} else {
				//자동 저장 시작
				autoSaver = new AutoSaver(account);
				autoSaver.setDaemon(true);
				autoSaver.start();
				System.out.println("자동저장이 시작되었습니다.");
			}
		} else if (input.equals("2")) {
			if (autoSaver != null && autoSaver.isAlive()) { //경고메세지 출력
				//자동 저장 중지
				autoSaver.interrupt();
				System.out.println("※ 자동저장이 중지되었습니다.");
			} else {
				System.out.println("※ 자동저장이 실행중이지 않습니다.");
			}
		} else { //1 또는 2이외 선택시 출력
			System.out.println("※ 잘못된 입력입니다. 1 또는 2를 선택(입력)해주세요");
		}
	}
	
	public static void showMenu() {
			System.out.println("==========메뉴 선택=============");
			System.out.println("1. 계좌개설");
			System.out.println("2. 입금");
			System.out.println("3. 출금");
			System.out.println("4. 전체계좌정보출력");
			System.out.println("5. 계좌정보삭제");
			System.out.println("6. 저장옵션");
			System.out.println("7. 프로그램종료");
			System.out.println("==============================");
		} 
		
	
	// 계좌개설을 위한 함수
	public static void makeAccount() {
		int choice = 0; //사용자 선택값을 저장할 변수
		
		while (true) {
	        try {
	        	System.out.println("==========계좌 선택=============");
	            System.out.println("1. 보통예금계좌  2. 신용신뢰계좌");
	            System.out.println("선택: ");
	            String input = scan.nextLine(); 
	            
	            
	            if (!input.equals("1") && !input.equals("2")) {
	                throw new InputMismatchException("1 또는 2만 입력 가능합니다.");
	            }
	            choice = Integer.parseInt(input);
	            break;
	        } catch (InputMismatchException e) {
	            System.out.println("※ 예외: " + e.getMessage());
	        }
	    }

		System.out.println("==========계좌 생성=============");
		System.out.print("계좌번호: ");
		String a = scan.nextLine();
		System.out.print("이름: ");
		String n = scan.nextLine();
		System.out.print("잔고: ");
		int b = scan.nextInt();
		System.out.print("이자율%(정수형태로입력): ");
		int interest = scan.nextInt();
		scan.nextLine();
		
		Account newAcc;
		
		if (choice == 1) {
			newAcc = new NormalAccount(a, n, b, interest);
		} else {
			String grade = "";
			int creditRate = 0;
			// 신용등급 설정
			if (interest >= A) {
				creditRate = A;
				grade = "A";
			} else if (interest >= B) {
				creditRate = B;
				grade = "B";
			} else {
				creditRate = C;
				grade = "C";
			}
			
			System.out.println("신용등급>"+grade+"(추가이자율: "+ creditRate + "%)");
			newAcc = new HighCreditAccount(a, n, b, interest,grade);
		}
		
		//계좌 중복 확인 후 추가
		boolean isAdd = account.add(newAcc);
		
		if(!isAdd) {
			System.out.println("중복계좌발견됨. 덮어쓸까요?(y or n): ");
			String answer = scan.nextLine();
			if (answer.equalsIgnoreCase("y")) {
				account.remove(newAcc);
				account.add(newAcc);
				System.out.println("기존정보를 삭제하고 덮어썻습니다.");
			} else {
				System.out.println("신규정보 저장이 취소되었습니다.");
			}
			return;
		}
		System.out.println("신규계좌 개설 완료");
	}
	
	// 입    금
	public static void depositMoney()  {
		try {
		System.out.println("==========입   금=============");
		System.out.print("계좌번호: ");
		String a= scan.nextLine();
		Account acc = findAccount(a);
		if (acc == null) {
			return;
		}
		System.out.println("*입금액은 500원 단위로만 입금 가능합니다*");
		System.out.print("입금액: ");
		int d = scan.nextInt();
		scan.nextLine();
		
		if (d <= 0) {
			System.out.println("음수는 입금할 수 없습니다.");
			return;
		}
		if (d % 500 != 0) {
			System.out.println("입금은 500원 단위로만 가능합니다.");
			return;
		}
		acc.deposit(d);
		System.out.println("예금이 성공되었습니다.");
		} catch (InputMismatchException e) {
			scan.nextLine();
			System.out.println("숫자만 입력하세요.");
		}
	}
	
	// 출    금
	public static void withdrawMoney() {
		try {
			System.out.println("==========출   금=============");
			System.out.print("계좌번호: ");
			String a= scan.nextLine();
			Account acc =findAccount(a);
			if (acc == null) return;
			
			System.out.print("출금액: ");
			int d = scan.nextInt();
			scan.nextLine();
			
			if (d <= 0) {
				System.out.println("음수는 출금할 수 없습니다.");
				return;
			}
			if (d % 1000 != 0) {
				System.out.println("출금은 1000원 단위로만 가능합니다.");
				return;
			}
			int remain = acc.getBalance() - d;
			if (remain < 0) {
				System.out.println("잔고가 부족합니다. 금액전체를 출금할까요? (YES/NO)");
				String choice = scan.nextLine();
				if (choice.equalsIgnoreCase("YES")) {
					acc.setBalance(0);
					System.out.println("전액 출금처리 되었습니다.");
				}else {
					System.out.println("출금요청이 취소되었습니다.");
				}
			} else {
				acc.setBalance(remain);
				System.out.println("출금이 성공되었습니다.");
			}
		}catch (InputMismatchException e) {
			scan.nextLine();
			System.out.println("숫자만 입력하세요.");
		}
	}
	
	
	// 전체계좌정보출력
	public static void showAccInfo() {
		for(Account acc : account) {
			//Account 클래스에서 toString을 오버라이딩 
			//했으므로 인스턴스를 그대로 출력
			System.out.println(acc);
		}
		System.out.println("*전체계좌정보가 출력됨*");
	}
	// 계좌정보 삭제
	public static void deleteAccount() {
		System.out.println("==========계좌정보삭제=============");
		System.out.println("삭제할 계좌번호: ");
		String accNum = scan.nextLine();
		Account acc = findAccount(accNum);
		if (acc == null) {
			return;
		}
		account.remove(acc);
		System.out.println("계좌가 삭제되었습니다.");
	}
	
	//계좌를 찾는 함수
	private static Account findAccount(String accNum) {
		for (Account acc : account) {
			if (acc.getAccNum().equals(accNum)) {
				return acc;
			}
		}
		System.out.println("해당 계좌를 찾을 수 없습니다.");
		return null;
	}
	//매뉴선택 1~7번까지만 선택 가능하게 하기
	public static int getMenuChoice() throws MenuSelectException {
		try {
			System.out.println("메뉴선택: ");
			int choice = Integer.parseInt(scan.nextLine());
			if (choice <1 || choice > 7) {
				throw new MenuSelectException("1~7 사이의 숫자만 입력 가능합니다.");
			}
			return choice;
		} catch (NumberFormatException e) {
			throw new MenuSelectException("숫자만 입력해야 합니다.");
		}
	}
	
}
