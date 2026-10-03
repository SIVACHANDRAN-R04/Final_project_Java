import java.util.Scanner;

class BankAccount {

    String accountHolderName;
    double balance;

    BankAccount(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Amount Deposited: " + amount);
        System.out.println("Current Balance: " + balance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Amount Withdrawn: " + amount);
            System.out.println("Current Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}


class BankTransaction extends BankAccount {

    BankTransaction(String accountHolderName, double balance) {
        super(accountHolderName, balance);
    }

    void showAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}


class ATM extends BankTransaction {

    int pin = 1234;

   ATM(String accountHolderName, double balance) {
        super(accountHolderName, balance);
    }

    void checkPin(int enteredPin, int choice, double amount) {

        if (enteredPin == pin) {

            System.out.println("PIN Verified Successfully");

            if (choice == 1) {
                deposit(amount);
            }
            else if (choice == 2) {
                withdraw(amount);
            }

        } else {
            System.out.println("Access Denied - Wrong PIN");
        }
    }
}


public class Banking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        ATM atm = new ATM(name, balance);

        atm.showAccountDetails();

        System.out.println("\n1. Deposit");
        System.out.println("2. Withdraw");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter ATM PIN: ");
        int enteredPin = sc.nextInt();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        atm.checkPin(enteredPin, choice, amount);

        sc.close();
    }
}