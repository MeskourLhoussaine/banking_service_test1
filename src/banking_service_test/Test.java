package banking_service_test;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountService account = new Account();
		account.deposit(1000);
		account.withdraw(200);
		account.printStatement();
		
	}

}
