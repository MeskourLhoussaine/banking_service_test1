package banking_service_test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService {
  
	private int balance=0;
	
	private final List<Transaction>transactions=new ArrayList<>();
	
	// Déposer un montant sur le compte
	@Override
	public void deposit(int amount) {
		 if (!isValidAmount(amount)) {
	            System.out.println("Erreur : le montant du dépôt doit être strictement positif.");
	            return;
	        }
	        balance += amount;
	        saveTransaction(amount);
		
	}
	
	// Retirer un montant du compte
	@Override
	public void withdraw(int amount) {
		// TODO Auto-generated method stub
		
		validateAmount(amount);           
        if (balance < amount) {
            throw new IllegalArgumentException("Soldes insuffisants.");
        }
        balance -= amount;                
        saveTransaction(-amount);         
		
	}
  // Afficher historique des transactions
	@Override
	public void printStatement() {
		System.out.println("DATE | OPERATION | MONTANT | SOLDE");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
		
	}
	
	// Vérifie que le montant est supérieur a 0
	 private void validateAmount(int amount) {
	        if (amount <= 0) {
	            throw new IllegalArgumentException("Amount doit etre  positive.");
	        }
	    }
	  
	// Enregistre une transaction dans la liste
	    private void saveTransaction(int amount) {
	        transactions.add(new Transaction(LocalDate.now(), amount, balance));
	    }
	    
	 // Validation du montant (positif strictement)
	    private boolean isValidAmount(int amount) {
	        return amount > 0;
	    }
}
