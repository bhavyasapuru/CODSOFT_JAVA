import java.util.Scanner;


class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            System.out.println("\nInsufficient funds");
            return false;
        }
    }
}


class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println();
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("\nChoose an option: ");
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("\nWithdrawal successful.\nCurrent balance: Rs." + account.getBalance());
        } else {
            System.out.println("Withdrawal failed!");
        }
    }

    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("\nDeposit successful. \nCurrent balance: Rs." + account.getBalance());
    }

    public void checkBalance() {
        System.out.println("\nCurrent balance: Rs." + account.getBalance());
    }
}

public class Main_ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter initial balance: ");
        double initialBalance = sc.nextDouble();
        BankAccount account = new BankAccount(initialBalance);
        ATM atm = new ATM(account);

        while (true) {
            atm.displayMenu();
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("\nEnter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("\nEnter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("\nThank You!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid option. Please try again.");
            }
        }
    }
}
