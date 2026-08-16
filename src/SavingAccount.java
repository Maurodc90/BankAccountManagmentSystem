/**
 * A savings account that requires a minimum balance of £100.
 * Withdrawals that would drop the balance below £100 are refused.
 */
public class SavingAccount extends Account {

    /**
     * Creates a new savings account with the given details.
     *
     * @param accountNumber unique identifier for this account
     * @param name          the account holder's name
     * @param balance       the initial deposit amount
     */
    protected SavingAccount(int accountNumber, String name, double balance) {
        super(accountNumber, name, balance);
        this.accountType = "Saving";
    }

    /**
     * Attempts to withdraw the given amount.
     * Refuses the withdrawal if the resulting balance would fall below £100.
     *
     * @param amount the amount to withdraw
     * @return true if the withdrawal was successful, false if it was refused
     */
    @Override
    protected boolean withdraw(double amount) {
        if (balance - amount < 100) {
            System.out.println("The saving Account require a minimum balance of 100.00£");
            return false;
        } else {
            balance = balance - amount;
            System.out.println("The new balance is " + balance);
            recordWithdrawal(amount);
            return true;
        }
    }
}