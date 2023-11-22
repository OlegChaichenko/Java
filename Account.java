package  projecttest;
import java.util.ArrayList;
import java.util.List;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.util.List;
public abstract class Account {
    private String accountNumber;
    private double balance;
    public List<Transaction> transactionHistory;
    private static List<Account> allAccounts = new ArrayList<>();

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
        allAccounts.add(this);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            recordTransaction("Deposit", amount);
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public abstract void withdraw(double amount);

    public void printStatement() {
        System.out.println("Account Statement for: " + accountNumber);
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
        System.out.println("Balance: " + balance);
    }

    public void makePayment(Account toAccount, double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            toAccount.deposit(amount);
            recordTransaction("Payment to " + toAccount.getAccountNumber(), amount);
            System.out.println("Payment of " + amount + " made to account " + toAccount.getAccountNumber());
        } else {
            System.out.println("Invalid payment amount or insufficient balance.");
        }

    }

    public abstract void generateStatement();

    public void recordTransaction(String description, double amount) {
        Transaction transaction = new Transaction(description, amount);
        transactionHistory.add(transaction);
    }

    public class Transaction {
        private String description;
        private double amount;

        public Transaction(String description, double amount) {
            this.description = description;
            this.amount = amount;
        }
        public String getDescription() {
            return description;
        }

        public double getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return description + " - " + amount;
        }
    }


    public void generateStatement1() {
        String fileName = getAccountNumber() + "_statement.pdf";

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();


            document.add(new Paragraph("Account Statement for: " + getAccountNumber()));
            document.add(new Paragraph("Balance: " + getBalance()));
            document.add(new Paragraph("Transaction History:"));


            for (Transaction transaction : transactionHistory) {
                document.add(new Paragraph(transaction.toString()));
            }

            document.close();
            System.out.println("Statement generated: " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void generateStatement2(String fileName) {
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName));
            WritableSheet sheet = workbook.createSheet("Transaction History", 0);


            String[] headers = {"Account Number", "Description", "Amount"};
            for (int i = 0; i < headers.length; i++) {
                Label label = new Label(i, 0, headers[i]);
                sheet.addCell(label);
            }

            int row = 1;


            for (Account account : allAccounts) {

                Label accountNumberLabel = new Label(0, row, account.getAccountNumber());
                sheet.addCell(accountNumberLabel);


                Label initialBalanceLabel = new Label(1, row, "Initial Balance");
                sheet.addCell(initialBalanceLabel);

                jxl.write.Number initialBalanceValue = new jxl.write.Number(2, row, account.getBalance());
                sheet.addCell(initialBalanceValue);
                row++;

               
                for (Account.Transaction transaction : account.transactionHistory) {
                    Label descriptionLabel = new Label(1, row, transaction.getDescription());
                    sheet.addCell(descriptionLabel);

                    jxl.write.Number amountLabel = new jxl.write.Number(2, row, transaction.getAmount());
                    sheet.addCell(amountLabel);
                    row++;
                }
            }

            workbook.write();
            workbook.close();

            System.out.println("Statement generated: " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
