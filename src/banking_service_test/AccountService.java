package banking_service_test;

public interface AccountService {
	void deposit(int amount);
	void withdraw(int amount);
	void printStatement();

}
