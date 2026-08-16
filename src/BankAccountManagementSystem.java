import java.util.ArrayList;

/**
 * Main class for the Bank Account Management System.
 * Handles the application loop and coordinates between the Menu and Account classes.
 */
public class BankAccountManagementSystem {

    static boolean systemOn = true;
    static ArrayList<Account> accounts = new ArrayList<>();
    static Menu menu = new Menu();

    /**
     * Entry point for the banking system.
     * Runs the main menu loop until the user chooses to exit.
     */
    public static void main(String[] args) {

        do {
            switch (menu.mainMenu()) {
                case 1:
                    Account newAccount = menu.createAccount(menu.selectAccountType());
                    if (newAccount != null) {
                        if (findAccount(newAccount.accountNumber) != null) {
                            System.out.println("The account number is already in use try with another one");
                        } else {
                            accounts.add(newAccount);
                        }
                    }
                    break;

                case 2:
                    if (!accounts.isEmpty()) {
                        int accountToVerify = menu.loginAccount();
                        Account loggedInAccount = findAccount(accountToVerify);
                        if (loggedInAccount != null) {
                            boolean loggedIn = true;
                            do {
                                switch (menu.accountMenu(loggedInAccount)) {
                                    case 1:
                                        loggedInAccount.displayBalance();
                                        break;
                                    case 2:
                                        loggedInAccount.deposit(menu.depositMenu());
                                        break;
                                    case 3:
                                        loggedInAccount.withdraw(menu.withdrawMenu());
                                        break;
                                    case 4:
                                        Account transferAccount = findAccount(menu.selectTransferAccount());
                                        if (transferAccount != null) {
                                            double amount = menu.enterTransferAmount();
                                            loggedInAccount.transferMoney(amount, transferAccount);
                                        } else {
                                            System.out.println("That account does not exist");
                                        }
                                        break;
                                    case 5:
                                        loggedInAccount.transactionHistory();
                                        break;
                                    case 7:
                                        if (menu.deleteAccount() == 1) {
                                            System.out.println("Account has been deleted successfully");
                                            accounts.remove(loggedInAccount);
                                            loggedIn = false;
                                        }
                                        break;
                                    case 8:
                                        loggedIn = false;
                                        System.out.println("Logging Out");
                                        break;
                                    case 9:
                                        loggedIn = false;
                                        systemOn = false;
                                        System.out.println("Thank you for using the bank management system!");
                                        break;
                                    default:
                                        System.out.println("Invalid input");
                                        break;
                                }
                            } while (loggedIn);
                        } else {
                            System.out.println("No Account fond with that account number");
                        }
                    } else {
                        System.out.println("No Account saved");
                    }
                    break;

                case 9:
                    systemOn = false;
                    System.out.println("Thank you for using the bank management system!");
                    break;

                default:
                    System.out.println("Please select a valid option");
            }
        } while (systemOn);
    }

    /**
     * Displays all accounts currently in the system.
     */
    static void displayAllAccounts() {
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            account.displayAccount();
            System.out.println("------------------------------------------");
        }
    }

    /**
     * Searches for an account by its account number.
     *
     * @param accountToVerify the account number to search for
     * @return the matching Account, or null if no account was found
     */
    static Account findAccount(int accountToVerify) {
        for (Account account : accounts) {
            if (account.accountNumber == accountToVerify) {
                return account;
            }
        }
        return null;
    }
}