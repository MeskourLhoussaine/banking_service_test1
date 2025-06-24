package banking_service_test;



import java.time.LocalDate;

// Représente une transaction bancaire (dépôt ou retrait)
public class Transaction {
    private LocalDate date;
    private int amount;
    private int balanceAfterTransaction;

    public Transaction(LocalDate date, int amount, int balanceAfterTransaction) {
        this.date = date;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public int getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    @Override
    public String toString() {
        return date + " | " +
               (amount >= 0 ? "DEPOSIT " : "WITHDRAW ") +
               Math.abs(amount) + " | BALANCE: " + balanceAfterTransaction;
    }
}
