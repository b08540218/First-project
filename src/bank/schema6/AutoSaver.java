package bank.schema6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class AutoSaver extends Thread{

	private Set<Account> accounts;
	private static final String FILE_NAME = "AutoSaveAccount.txt";
	
	public AutoSaver(Set<Account> accounts) {
		this.accounts = accounts;
		setDaemon(true);
	}

	@Override
	public void run() {
		while (true) {
			try {
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
	private void SaveFile() throws IOException{
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
			for (Account account : accounts) {
				writer.write(account.toString());
				writer.newLine();
			}
		}
		System.out.printf("\n자동저장 완료: " + accounts.size()+ "건 ");
	}
}
