package banking_service_test;

public class Test {

	public static void main(String[] args) {
		
		AccountService account = new Account();
		 // Tests valides
        account.deposit(1000);
        account.withdraw(300);
        account.deposit(200);

        // Tests invalides
        account.deposit(0);           // Rejeté
        account.withdraw(-100);      // Rejeté
        account.withdraw(2000);      // Solde insuffisant

        // Affichage du relevé
        account.printStatement();
    
	}

}
