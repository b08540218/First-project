package banking;


public class BankingSystemMain extends AccountManager{	

//	public static Scanner scan = new Scanner(System.in);
	
//	static String BankNumber;
//	static String Name;
//	int Money;
//	
	public static void main(String[] args) {
		//Scanner scan = new Scanner(System.in);
		
//		Account handler = new Account(50);
		AccountManager handler = new AccountManager();
		while (true) {
			showMenu();
			try {
				
				int choice = sc.nextInt();
				sc.nextLine();
//				scan.nextInt(); //오류코드
				switch (choice) {
				case 1:
					handler.makeAccount();
					break;
				case 2:
					handler.depositMoney();
					break;
				case 3:
					handler.withdrawMoney();
					break;
				case 4:
					handler.showAccInfo();
					break;
				case 5:
					System.out.println("프로그램종료");
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
