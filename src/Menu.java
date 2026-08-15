import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public int mainMenu() {
        System.out.println("-------------------------------------------");
        System.out.println("Welcome to Bank Accounts Management System");
        System.out.println("1. Create a new account");
        System.out.println("2. Login on your account");
        System.out.println("3. Display accounts"); // TODO Only for Debugging Purpose
        System.out.println("9. Exit");
        System.out.println("-------------------------------------------");
        System.out.print("Select your choice: ");
        return intValidator();
    }

    // Which type of account to create
    public int selectAccountType() {
        System.out.println("-------------------------------------------");
        System.out.println("1. Current Account");
        System.out.println("2. Saving Account");
        System.out.println("3. Back");
        System.out.println("-------------------------------------------");
        System.out.print("Select your choice: ");
        return intValidator();
    }

    // Create an account
    public Account createAccount(int choice) {
        String name;
        double balance;
        int accountNumber;
        Account account;
        System.out.println("-----------------------------------------");
        System.out.println("Enter your name");
        name = scanner.nextLine();
        System.out.println("How much do you want to deposit?");
        balance = scanner.nextDouble();
        System.out.println("Enter your account number");
        accountNumber = intValidator();

        switch (choice) {
            case 1:
                account = new CurrentAccount(accountNumber, name, balance);
                break;
            case 2:
                account = new SavingAccount(accountNumber, name, balance);
                break;
            default:
                System.out.println("Invalid Choice try again");
                return null;
        }

        System.out.println("Thank you your account was created");
        System.out.println("-----------------------------------------");


        return account;
    }

    // Login in your account after asked select account
    public int loginAccount() {
        System.out.println("------------------------------------------");
        System.out.println(" Enter your account Number");
        System.out.println("------------------------------------------");
        return intValidator();
    }


    // Once the account was selected
    public int accountSelected(Account account) {
        System.out.println("------------------------------------------");
        System.out.println("Welcome " + account.name);
        System.out.println("Account Number: " + account.accountNumber);
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("7. Delete Account");
        System.out.println("8. Back");
        System.out.println("9. Exit");
        System.out.println("------------------------------------------");
        return intValidator();
    }

    public double depositMenu() {
        System.out.println("------------------------------------------");
        System.out.println("Enter your amount to deposit");
        return doubleValidator();
    }

    public double withdrawMenu() {
        System.out.println("----------------------------------------");
        System.out.println("Enter your amount to withdraw");
        System.out.println("-----------------------------------------");
        return doubleValidator();
    }
    public int transferMenu() {
        System.out.println("----------------------------------------");
        System.out.println("Enter the Account Number");
        System.out.println("-----------------------------------------");
        return intValidator();
    }
    public double transferMoneyMenu() {
        System.out.println("---------------------------------------");
        System.out.println("Enter your amount to transfer");
        System.out.println("-----------------------------------------");
        return doubleValidator();
    }

    public int deleteAccount() {
        System.out.println("----------------------------------------");
        System.out.println("Are you sure you want to delete this account?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("----------------------------------------");
        System.out.println("Select your choice: ");
        return intValidator();
    }


    // Validate the user input
    private int intValidator() {
        int choice;
        while (!scanner.hasNextInt()) {
            System.out.println("Please Insert a Valid Number.");
            scanner.next();
        }
        choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private double doubleValidator() {
        boolean isPositive = false;
        double amount;
        do {
            while (!scanner.hasNextDouble()) {
                System.out.println("Please Insert a Valid Number.");
                scanner.next();
            }

            amount = scanner.nextDouble();
            if (amount > 0) {
                scanner.nextLine();
                isPositive = true;
            } else {
                System.out.println("Please Insert Positive Number.");
            }
        } while (!isPositive);
        return amount;
    }


}
