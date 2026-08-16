/**
 * A current (checking) account that allows an overdraft up to -£500.
 * Withdrawals that would push the balance below -£500 are refused.
 */
public class CurrentAccount extends Account {

    /**
     * Creates a new current account with the given details.
     *
     * @param accountNumber unique identifier for this account
     * @param name          the account holder's name
     * @param balance       the initial deposit amount
     */
    protected CurrentAccount(int accountNumber, String name, double balance) {
        super(accountNumber, name, balance);
        this.accountType = "Current";
    }

    /**
     * Attempts to withdraw the given amount.
     * Refuses the withdrawal if the resulting balance would fall below -£500.
     *
     * @param amount the amount to withdraw
     * @return true if the withdrawal was successful, false if it was refused
     */
    @Override
    protected boolean withdraw(double amount) {
        if (balance - amount < -500) {
            System.out.println("The Current Account can have an overdraft of maximum 500.00£");
            return false;
        } else {
            balance = balance - amount;
            System.out.println("The new balance is " + balance);
            recordWithdrawal(amount);
            return true;
        }
    }
}