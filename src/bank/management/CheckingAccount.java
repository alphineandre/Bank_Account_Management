package bank.management;

public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountHolder, double balance, double overdraftLimit) {
        super(accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > getBalance() + overdraftLimit) {
            throw new InsufficientFundsException("Overdraft limit exceeded.");
        }
        super.withdraw(amount);
    }
}

