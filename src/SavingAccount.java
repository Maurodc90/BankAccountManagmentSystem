public class SavingAccount extends Account {


    // Must Have Balance of 100

    protected SavingAccount(int accountNumber, String name, double balance) {
        super(accountNumber, name, balance);
        this.accountType = "Saving";
    }

    @Override
    protected boolean withdraw(double amount) {
        if (balance - amount < 100) {
            System.out.println("The saving Account require a minimum balance of 100.00£");
            return false;
        } else {
            balance = balance - amount;
            System.out.println("The new balance is " + balance);
            return  true;
        }
    }

}
