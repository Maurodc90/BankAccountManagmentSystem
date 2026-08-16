import java.util.ArrayList;

/**
 * Abstract base class representing a bank account.
 * Defines shared state and behaviour for all account types.
 * Cannot be instantiated directly — subclasses must implement withdrawal rules.
 */
abstract class Account {

    protected int accountNumber;
    protected String name;
    protected double balance;
    protected String accountType;
    protected ArrayList<String> transactions = new ArrayList<>();

    /**
     * Creates a new account with the given details and records the initial deposit.
     *
     * @param accountNumber unique identifier for this account
     * @param name          the account holder's name
     * @param balance       the initial deposit amount
     */
    protected Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        transactions.add("Transaction 1: Creating account. Deposited: " + balance + "£. Current balance: " + balance + "£.");
    }

    /**
     * Prints the account number, holder name, balance, and account type.
     */
    protected void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
        System.out.println("Account Type: " + accountType);
    }

    /**
     * Prints the current balance.
     */
    protected void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }

    /**
     * Adds the given amount to the balance and records the transaction.
     *
     * @param amount the amount to deposit (must be positive)
     */
    protected void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited " + amount);
        System.out.println("Account Balance: " + balance);
        transactions.add("Transaction " + transactionNumber() + ": Deposited " + amount + "£. Current balance: " + balance + "£.");
    }

    /**
     * Attempts to withdraw the given amount from the account.
     * Each subclass enforces its own withdrawal rules.
     *
     * @param amount the amount to withdraw (must be positive)
     * @return true if the withdrawal was successful, false if it was refused
     */
    protected abstract boolean withdraw(double amount);

    /**
     * Records a withdrawal entry in the transaction history.
     * Called by subclasses after a successful withdrawal.
     *
     * @param amount the amount that was withdrawn
     */
    protected void recordWithdrawal(double amount) {
        transactions.add("Transaction " + transactionNumber() + ": Withdraw " + amount + "£. Current balance: " + balance + "£.");
    }

    /**
     * Transfers money from this account to another account.
     * Uses this account's withdraw rules to validate the transfer.
     * Records the transaction in both accounts' histories.
     *
     * @param amount  the amount to transfer
     * @param account the destination account
     */
    protected void transferMoney(double amount, Account account) {
        if (withdraw(amount)) {
            account.balance = account.balance + amount;
            account.transactions.add("Transaction " + account.transactionNumber() + ": Received " + amount + "£ from " + name + ". Current balance: " + account.balance + "£.");
            System.out.println("Transfer to " + account.name + " successful");
            System.out.println("The new balance is " + balance);
            transactions.add("Transaction " + transactionNumber() + ": Transfer " + amount + "£ to " + account.name + ". Current balance: " + balance + "£.");
        } else {
            System.out.println("Transfer Failed");
        }
    }

    /**
     * Returns the next transaction number based on the current history size.
     *
     * @return the next sequential transaction number
     */
    private int transactionNumber() {
        return transactions.size() + 1;
    }

    /**
     * Prints the full transaction history for this account.
     */
    protected void transactionHistory() {
        System.out.println("----------------------------------------");
        System.out.println("Transaction History for " + name + ":");
        for (String entry : transactions) {
            System.out.println(entry);
        }
        System.out.println("----------------------------------------");
    }
}