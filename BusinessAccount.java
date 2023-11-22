package  projecttest;

public class BusinessAccount extends Account {
    private String businessName;

    public BusinessAccount(String accountNumber, double balance, String businessName) {
        super(accountNumber, balance);
        this.businessName = businessName;
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
        System.out.println("Business Account Statement for: " + getAccountNumber());
        System.out.println("Business Name: " + businessName);
    }}