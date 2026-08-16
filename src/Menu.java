import java.util.Scanner;

/**
 * Handles all user-facing menus and input for the banking system.
 * Owns the Scanner and validates all user input before returning it.
 */
public class Menu {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Displays the main menu and returns the user's choice.
     *
     * @return the validated menu option selected by the user
     */
    public int mainMenu() {
        System.out.println("-------------------------------------------");
        System.out.println("Welcome to Bank Accounts Management System");
        System.out.println("1. Create a new account");
        System.out.println("2. Login on your account");
        System.out.println("9. Exit");
        System.out.println("-------------------------------------------");
        System.out.print("Select your choice: ");
        return validateInt();
    }

    /**
     * Displays the account type selection menu and returns the user's choice.
     *
     * @return the validated account type option (1 = Current, 2 = Saving, 3 = Back)
     */
    public int selectAccountType() {
        System.out.println("-------------------------------------------");
        System.out.println("1. Current Account");
        System.out.println("2. Saving Account");
        System.out.println("3. Back");
        System.out.println("-------------------------------------------");
        System.out.print("Select your choice: ");
        return validateInt();
    }

    /**
     * Collects account details from the user and creates the appropriate account type.
     *
     * @param choice the account type selected (1 = Current, 2 = Saving)
     * @return the newly created Account, or null if the choice was invalid
     */
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
        accountNumber = validateInt();

        switch (choice) {
            case 1:
                account = new CurrentAccount(accountNumber, name, balance);
                break;
            case 2:
                if (balance >= 100) {
                account = new SavingAccount(accountNumber, name, balance);
                } else{
                    System.out.println("Insufficient balance to create the account");
                    System.out.println("100.0£ minimum balance required");
                    return null;
                }

                break;
            default:
                System.out.println("Invalid Choice try again");
                return null;
        }

        System.out.println("Thank you your account was created");
        System.out.println("-----------------------------------------");
        return account;
    }

    /**
     * Prompts the user to enter their account number for login.
     *
     * @return the validated account number
     */
    public int loginAccount() {
        System.out.println("------------------------------------------");
        System.out.println(" Enter your account Number");
        System.out.println("------------------------------------------");
        return validateInt();
    }

    /**
     * Displays the account menu for a logged-in user and returns their choice.
     *
     * @param account the currently logged-in account (used to display name and number)
     * @return the validated menu option selected by the user
     */
    public int accountMenu(Account account) {
        System.out.println("------------------------------------------");
        System.out.println("Welcome " + account.name);
        System.out.println("Account Number: " + account.accountNumber);
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Transaction History");
        System.out.println("7. Delete Account");
        System.out.println("8. Back");
        System.out.println("9. Exit");
        System.out.println("------------------------------------------");
        return validateInt();
    }

    /**
     * Prompts the user to enter a deposit amount.
     *
     * @return the validated positive deposit amount
     */
    public double depositMenu() {
        System.out.println("------------------------------------------");
        System.out.println("Enter your amount to deposit");
        return validateDouble();
    }

    /**
     * Prompts the user to enter a withdrawal amount.
     *
     * @return the validated positive withdrawal amount
     */
    public double withdrawMenu() {
        System.out.println("----------------------------------------");
        System.out.println("Enter your amount to withdraw");
        System.out.println("-----------------------------------------");
        return validateDouble();
    }

    /**
     * Prompts the user to enter the destination account number for a transfer.
     *
     * @return the validated account number of the transfer destination
     */
    public int selectTransferAccount() {
        System.out.println("----------------------------------------");
        System.out.println("Enter the Account Number");
        System.out.println("-----------------------------------------");
        return validateInt();
    }

    /**
     * Prompts the user to enter the amount to transfer.
     *
     * @return the validated positive transfer amount
     */
    public double enterTransferAmount() {
        System.out.println("---------------------------------------");
        System.out.println("Enter your amount to transfer");
        System.out.println("-----------------------------------------");
        return validateDouble();
    }

    /**
     * Asks the user to confirm account deletion.
     *
     * @return the validated choice (1 = Yes, 2 = No)
     */
    public int deleteAccount() {
        System.out.println("----------------------------------------");
        System.out.println("Are you sure you want to delete this account?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("----------------------------------------");
        System.out.println("Select your choice: ");
        return validateInt();
    }

    /**
     * Validates that the user enters a valid integer.
     * Re-prompts until a valid integer is provided.
     *
     * @return the validated integer
     */
    private int validateInt() {
        int choice;
        while (!scanner.hasNextInt()) {
            System.out.println("Please Insert a Valid Number.");
            scanner.next();
        }
        choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    /**
     * Validates that the user enters a valid positive number.
     * Re-prompts until a positive double is provided.
     *
     * @return the validated positive double
     */
    private double validateDouble() {
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