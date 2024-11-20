package bank.management;

import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create some accounts for testing
        BankAccount account1 = new BankAccount("John Doe", 1000);
        BankAccount account2 = new BankAccount("Jane Smith", 500);

        while (true) {
            System.out.println("\n=== Bank Account Management ===");
            System.out.println("1. View Account Details");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accountNumber = scanner.nextInt();
                    BankAccount account = (accountNumber == account1.getAccountNumber()) ? account1 : account2;
                    System.out.println("Account Holder: " + account.getAccountHolder());
                    System.out.println("Balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextInt();
                    account = (accountNumber == account1.getAccountNumber()) ? account1 : account2;
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextInt();
                    account = (accountNumber == account1.getAccountNumber()) ? account1 : account2;
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    try {
                        account.withdraw(withdrawAmount);
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Enter Sender Account Number: ");
                    int senderAccountNumber = scanner.nextInt();
                    BankAccount sender = (senderAccountNumber == account1.getAccountNumber()) ? account1 : account2;
                    System.out.print("Enter Receiver Account Number: ");
                    int receiverAccountNumber = scanner.nextInt();
                    BankAccount receiver = (receiverAccountNumber == account1.getAccountNumber()) ? account1 : account2;
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    try {
                        sender.transfer(receiver, transferAmount);
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextInt();
                    account = (accountNumber == account1.getAccountNumber()) ? account1 : account2;
                    account.displayTransactionHistory();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

