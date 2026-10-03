import java.util.Scanner;

abstract class Bank {

    String accountHolder;
    double balance = 10000;

    Bank(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    abstract void deposit(double amount);

    abstract void withdraw(double amount);

    void displayAccount() {
        System.out.println("\nAccount Holder : " + accountHolder);
        System.out.println("Balance        : ₹" + balance);
    }
}

class SavingsAccount extends Bank {

    SavingsAccount(String accountHolder) {
        super(accountHolder);
    }

    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Amount Deposited: ₹" + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Amount Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}

class CurrentAccount extends Bank {

    CurrentAccount(String accountHolder) {
        super(accountHolder);
    }

    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Amount Deposited: ₹" + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Amount Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}

public class BankingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.println("\n--- Account Type ---");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        Bank bank;

        switch (choice) {

            case 1:
                bank = new SavingsAccount(name);
                break;

            case 2:
                bank = new CurrentAccount(name);
                break;

            default:
                System.out.println("Invalid Choice");
                sc.close();
                return;
        }

        System.out.println("\nDefault Initial Balance: ₹10000");

        System.out.println("\n--- Banking Menu ---");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Display Account");

        System.out.print("Enter your choice: ");
        int option = sc.nextInt();

        switch (option) {

            case 1:
                System.out.print("Enter Deposit Amount: ");
                double deposit = sc.nextDouble();
                bank.deposit(deposit);
                break;

            case 2:
                System.out.print("Enter Withdraw Amount: ");
                double withdraw = sc.nextDouble();
                bank.withdraw(withdraw);
                break;

            case 3:
                bank.displayAccount();
                break;

            default:
                System.out.println("Invalid Choice");
        }

        System.out.println("\n--- Account Details ---");
        bank.displayAccount();

        sc.close();
    }
}