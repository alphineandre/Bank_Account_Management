package bank.management;

public class Main {
    public static void main(String[] args) {
        // Create accounts
        SavingsAccount savings = new SavingsAccount("John Doe", 1000, 2);
        CheckingAccount checking = new CheckingAccount("Jane Smith", 500, 300);

        try {
            // Deposit and withdraw operations
            savings.deposit(200);
            savings.withdraw(300);
            savings.addInterest();

            checking.withdraw(700); // Overdraft usage
            checking.deposit(100);

        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

