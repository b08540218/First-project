package bank.schema6;

public class MenuSelectException extends Exception{
	
	/*
	예외 발생시 메시지를 상위 상위클래스(Exception)에 전달
	 */
	public MenuSelectException(String message) {
		super(message); 
		
	}
}
