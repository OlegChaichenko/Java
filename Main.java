package projecttest;
public class Main {
    public static void main(String[] args) {

        CheckingAccount checkingAccount = new CheckingAccount("CA001", 1000.0, 500.0);


        SavingsAccount savingsAccount = new SavingsAccount("SA001", 2000.0, 0.03);


        BusinessAccount businessAccount = new BusinessAccount("BA001", 1500.0, "My Business");


        checkingAccount.deposit(500.0);


        savingsAccount.withdraw(300.0);


        checkingAccount.makePayment(savingsAccount, 200.0);

     
        checkingAccount.generateStatement();
        savingsAccount.generateStatement();
        businessAccount.generateStatement();
        checkingAccount.generateStatement1();
        savingsAccount.generateStatement1();
        businessAccount.generateStatement1();
        Account.generateStatement2("all_accounts_statements.xls");

    }
}
