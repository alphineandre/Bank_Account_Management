package bank.management;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private static int nextAccountNumber = 1000; // For unique account numbers
    private final int accountNumber;
    private String accountHolder;
    private double balance;
    private final List<String> transactionHistory;

    public BankAccount(String accountHolder, double balance) {
        this.accountNumber = nextAccountNumber++;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount + ". New balance: " + balance);
        } else {
            transactionHistory.add("Failed deposit attempt: " + amount);
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            transactionHistory.add("Failed withdrawal attempt: " + amount + ". Insufficient funds.");
            throw new InsufficientFundsException("Insufficient funds. Balance: " + balance);
        }
        balance -= amount;
        transactionHistory.add("Withdrawn: " + amount + ". Remaining balance: " + balance);
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History for Account " + accountNumber + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
    public void transfer(BankAccount toAccount, double amount) throws InsufficientFundsException {
        if (amount > 0) {
            this.withdraw(amount);
            toAccount.deposit(amount);
            transactionHistory.add("Transferred: " + amount + " to Account " + toAccount.getAccountNumber());
            toAccount.transactionHistory.add("Received: " + amount + " from Account " + this.getAccountNumber());
        } else {
            transactionHistory.add("Failed transfer attempt: " + amount);
        }
    }

}
