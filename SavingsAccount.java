package projecttest;



public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && getBalance() >= amount) {
            double newBalance = getBalance() - amount;
            setBalance(newBalance);
            recordTransaction("Withdrawal", amount);
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    @Override
    public void generateStatement() {
        System.out.println("Savings Account Statement for: " + getAccountNumber());
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
        System.out.println("Balance: " + getBalance());
    }
}
