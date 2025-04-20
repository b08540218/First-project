package bank.schema6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

/*AutoSaver 클래스는 계좌 정보를 일정 주기로 자동으로 파일에 
저장하는 기능을 수행하는 스레드 클래스입니다. 
*/
public class AutoSaver extends Thread{

	// 저장할 계좌들을 담고 있는 Set<Account> 객체
	private Set<Account> accounts;
	
	//자동 저장될 파일 이름
	private static final String FILE_NAME = "AutoSaveAccount.txt";
	
	
	public AutoSaver(Set<Account> accounts) {
		this.accounts = accounts;
		setDaemon(true);
	}
	// 스레드의 실행 메소드: 계좌 정보를 일정 주기로 자동저장
	@Override
	public void run() {
		while (true) {
			try {
				//계좌정볼를 파일에 메소드 호출
				SaveFile();
				Thread.sleep(5000); //자동저장 5초에 한번씩 출력
			} catch (InterruptedException e) {
				System.out.println("***자동저장을 종료합니다***");
				break;
			}catch (IOException e) {
				System.out.print("***자동저장중 오류 발생***");
				e.printStackTrace();
			}
		}
	}
	//계좌정보를 파일에 저장하는 메소드
	private void SaveFile() throws IOException{
		// BufferedWriter를 이용해 파일에 기록
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
			//  Set<Account>의 모든 계좌 정보를 파일에 기록
			for (Account account : accounts) {
				writer.write(account.toString()); //계좌 정보를 문자열로 변환하여 기록
				writer.newLine();
			}
		}
		System.out.printf("\n자동저장 완료: " + accounts.size()+ "건 ");
	}
}
