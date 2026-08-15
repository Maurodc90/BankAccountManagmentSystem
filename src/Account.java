import java.util.ArrayList;

abstract class Account {

    protected int accountNumber;
    protected String name;
    protected double balance;
    protected String accountType;



    protected Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }


    protected void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
        System.out.println("Account Type: " + accountType);

    }


    protected void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }

    protected void deposit(double amount){
        balance = balance + amount;
    };

    protected abstract boolean withdraw(double amount);

    protected void transferMoney (double amount, Account account) {
        if (withdraw(amount)) {
            account.deposit(amount);
            System.out.println("Transfer Successful");
            System.out.println("Account Balance: " + balance);
        }  else {
            System.out.println("Transfer Failed");
        }
    }

}
