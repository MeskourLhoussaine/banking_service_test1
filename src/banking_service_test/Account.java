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
	            System.out.println("Erreur : le montant du dépot doit etre strictement positif.");
	            return;
	        }
	        balance += amount;
	        saveTransaction(amount);
		
	}
	
	// Retirer un montant du compte
	@Override
	public void withdraw(int amount) {
		if (!isValidAmount(amount)) {
            System.out.println("Erreur : le montant du retrait doit etre strictement positif.");
            return;
        }
        if (amount > balance) {
            System.out.println("Erreur : solde insuffisant pour effectuer le retrait.");
            return;
        }
        balance -= amount;
        saveTransaction(-amount);
	}
  // Afficher historique des transactions
	@Override
	public void printStatement() {
		 if (transactions.isEmpty()) {
	            System.out.println("Aucune transaction à afficher.");
	            return;
	        }

	        System.out.println("DATE | OPÉRATION | MONTANT | SOLDE");
	        for (Transaction t : transactions) {
	            System.out.println(t);
	        }
		
	}
	
	// Verifie que le montant est superieur a 0
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
	    
	 // Pour les tests : permet de récupérer le solde actuel
	    public int getBalance() {
	        return balance;
	    }
}
