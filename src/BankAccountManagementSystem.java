import java.util.ArrayList;


public class BankAccountManagementSystem {

    static boolean systemOn = true;
    static ArrayList<Account> accounts = new ArrayList<>();
    static Menu menu = new Menu();



    public static void main(String[] args) {
        Account mauro = new CurrentAccount(123, "Mauro", 100);
        Account elcin = new SavingAccount(345, "Elcin", 100);
        accounts.add(mauro);
        accounts.add(elcin);
        do {
            switch (menu.mainMenu()){
                // Create New Account
                case 1:
                    Account newAccount = menu.createAccount(menu.selectAccountType());
                    if(newAccount != null){
                        if(findAccount(newAccount.accountNumber) != null ){
                            System.out.println("The account number is already in use try with another one");
                        } else{
                            accounts.add(newAccount);
                        }

                    }break;

                // Select an account
                case 2:
                    if(!accounts.isEmpty()){
                        int accountToVerify = menu.loginAccount();
                        Account acc = findAccount(accountToVerify);
                        if(acc != null){
                            boolean loggedIn = true;
                            do{
                                switch (menu.accountSelected(acc)){
                                    case 1: acc.displayBalance(); break;
                                    case 2: acc.deposit(menu.depositMenu()); break;
                                    case 3: acc.withdraw(menu.withdrawMenu()); break;
                                    case 4:
                                        Account transferAccount = findAccount(menu.transferMenu());
                                        if(transferAccount != null){
                                            double amount = menu.transferMoneyMenu();
                                            acc.transferMoney(amount, transferAccount);
                                            break;
                                        } else {
                                            System.out.println("That account does not exist");
                                        }break;

                                    case 7:
                                        if (menu.deleteAccount() == 1) {
                                            System.out.println("Account has been deleted successfully");
                                            accounts.remove(acc);
                                            loggedIn = false;
                                        }
                                        break;
                                    case 8: loggedIn = false; System.out.println("Logging Out"); break;
                                    case 9: loggedIn = false; systemOn = false; System.out.println("Thank you for using the bank management system!"); break;
                                    default: System.out.println("Invalid input"); break;
                                }
                            } while (loggedIn);
                    }
                    else {System.out.println("No Account saved");}
                    } else {System.out.println("No Account saved");}

                break;
                // TODO Debug action to delete
                case 3: displayAccountInMenu(); break; // TODO Debug Option

                // Exit from the system
                case 9: systemOn = false; System.out.println("Thank you for using the bank management system!");break;
                default: System.out.println("Please select a valid option");
            }

        } while (systemOn);
    }

    static void displayAccountInMenu(){
        for( int i = 0; i < accounts.size(); i++){
            Account account = accounts.get(i);
            account.displayAccount();
            System.out.println("------------------------------------------");
        }
    }

    static Account findAccount(int accountToVerify){
        for(Account account : accounts){
            if(account.accountNumber == accountToVerify){
                return account;
            }
        }
        return null;
    }

}
