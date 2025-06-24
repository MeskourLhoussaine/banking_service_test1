package banking_service_test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService {
  
	private int balance=0;
	
	private final List<Transaction>transactions=new ArrayList<>();
	
	@Override
	public void deposit(int amount) {
		validateAmount(amount);
		balance += amount;
		saveTransaction(amount);
		
	}

	@Override
	public void withdraw(int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printStatement() {
		// TODO Auto-generated method stub
		
		System.out.println("DATE | OPERATION | MONTANT | SOLDE");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
		
	}
	
	 private void validateAmount(int amount) {
	        if (amount <= 0) {
	            throw new IllegalArgumentException("Amount doit etre  positive.");
	        }
	    }
	  
	// Enregistre une transaction dans la liste
	    private void saveTransaction(int amount) {
	        transactions.add(new Transaction(LocalDate.now(), amount, balance));
	    }
}
