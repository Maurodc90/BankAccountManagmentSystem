public class CurrentAccount extends Account {

    // Has overdraft up to 500


    protected CurrentAccount(int accountNumber, String name, double balance) {
        super(accountNumber, name, balance);
        this.accountType = "Current";
    }


    @Override
    protected boolean withdraw(double amount) {
        if (balance - amount < -500) {
            System.out.println("The Current Account can have an overdraft of maximum 500.00£");
            return false;
        } else {
            balance = balance - amount;
            System.out.println("The new balance is " + balance);
            return  true;
        }
    }
}
