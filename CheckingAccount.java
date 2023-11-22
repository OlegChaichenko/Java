package projecttest;

public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && getBalance() + overdraftLimit >= amount) {
            double newBalance = getBalance() - amount;
            setBalance(newBalance);
            recordTransaction("Withdrawal", amount);
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or overdraft limit exceeded.");
        }
    }

    @Override
    public void generateStatement() {
        System.out.println("Checking Account Statement for: " + getAccountNumber());
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
        System.out.println("Balance: " + getBalance());
    }
}
