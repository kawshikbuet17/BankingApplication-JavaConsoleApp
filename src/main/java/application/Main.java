package main.java.application;

import main.java.com.singleton.Bank;
import main.java.com.singleton.BankSingleton;
import main.java.com.banking.account.AccountType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = BankSingleton.getInstance().getBank();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount(bank, scanner);
                    break;
                case 2:
                    bank.displayAllAccounts();
                    break;
                case 3:
                    updateAccount(bank, scanner);
                    break;
                case 4:
                    deleteAccount(bank, scanner);
                    break;
                case 5:
                    depositAmount(bank, scanner);
                    break;
                case 6:
                    withdrawAmount(bank, scanner);
                    break;
                case 7:
                    searchAccount(bank, scanner);
                    break;
                case 8:
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }

        } while (choice != 8);

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("1. Create a new account");
        System.out.println("2. Display all accounts");
        System.out.println("3. Update an account");
        System.out.println("4. Delete an account");
        System.out.println("5. Deposit an amount into your account");
        System.out.println("6. Withdraw an amount from your account");
        System.out.println("7. Search for account");
        System.out.println("8. Exit");
    }

    private static void createAccount(Bank bank, Scanner scanner) {
        System.out.println("Select account type:");
        System.out.println("1. Current Account");
        System.out.println("2. Savings Account");
        System.out.println("3. Salary Account");
        System.out.print("Enter your choice: ");
        int accountTypeChoice = scanner.nextInt();

        AccountType accountType = getAccountType(accountTypeChoice);

        System.out.print("Enter account name: ");
        String accountName = scanner.next();

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        bank.createAccount(accountName, initialBalance, accountType);
    }

    private static void updateAccount(Bank bank, Scanner scanner) {
        System.out.print("Enter account number to update: ");
        String accountNumber = scanner.next();

        System.out.print("Enter updated account name: ");
        String updatedName = scanner.next();

        bank.updateAccount(accountNumber, updatedName);
    }

    private static void deleteAccount(Bank bank, Scanner scanner) {
        System.out.print("Enter account number to delete: ");
        String accountNumber = scanner.next();

        bank.deleteAccount(accountNumber);
    }

    private static void depositAmount(Bank bank, Scanner scanner) {
        System.out.print("Enter account number to deposit into: ");
        String accountNumber = scanner.next();

        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();

        bank.depositAmount(accountNumber, amount);
    }

    private static void withdrawAmount(Bank bank, Scanner scanner) {
        System.out.print("Enter account number to withdraw from: ");
        String accountNumber = scanner.next();

        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();

        bank.withdrawAmount(accountNumber, amount);
    }

    private static void searchAccount(Bank bank, Scanner scanner) {
        System.out.print("Enter account number to search: ");
        String accountNumber = scanner.next();

        bank.searchAccount(accountNumber);
    }

    private static AccountType getAccountType(int choice) {
        switch (choice) {
            case 1:
                return AccountType.CURRENT;
            case 2:
                return AccountType.SAVINGS;
            case 3:
                return AccountType.SALARY;
            default:
                throw new IllegalArgumentException("Invalid account type choice.");
        }
    }
}
