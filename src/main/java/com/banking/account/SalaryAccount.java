package main.java.com.banking.account;

import main.java.com.banking.util.InsufficientInitialDepositException;

import java.util.Date;

public class SalaryAccount implements Account {
    private static final AccountType ACCOUNT_TYPE = AccountType.SALARY;
    private static final double MINIMUM_BALANCE = 0.0;
    private static final double ACCOUNT_CLOSING_CHARGE = 0.0;
    private String accountName;
    private final String accountNumber;
    private final Date creationDate;
    private double balance;
    private boolean isActive;


    public SalaryAccount(String accountName, String accountNumber, Date creationDate, double initialBalance) throws InsufficientInitialDepositException {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.creationDate = creationDate;

        if (initialBalance >= MINIMUM_BALANCE) {
            this.balance = initialBalance;
            this.isActive = true;
        } else {
            throw new InsufficientInitialDepositException("Cannot create account. Initial deposit must be at least " + MINIMUM_BALANCE);
        }
    }

    @Override
    public AccountType getAccountType(){
        return ACCOUNT_TYPE;
    }
    @Override
    public void displayInfo() {
        System.out.println("Account Information:");
        System.out.println("Name: " + accountName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + ACCOUNT_TYPE);
        System.out.println("Creation Date: " + creationDate);
        System.out.println("Balance: " + balance);
    }

    @Override
    public String getAccountNumber(){
        return accountNumber;
    }

    @Override
    public boolean updateAccountName(String updatedName) {
        accountName = updatedName;
        return true;
    }

    @Override
    public boolean deleteAccount() {
        double withdrawalAmount = balance - ACCOUNT_CLOSING_CHARGE;
        balance = 0;
        System.out.println("Account closing charge " + ACCOUNT_CLOSING_CHARGE + " applied.");
        System.out.println("Amount withdrawn " + withdrawalAmount);
        isActive = false;
        return true;
    }

    @Override
    public void deposit(double amount) {
        if (isActive) {
            balance += amount;
            System.out.println(amount + " deposited successfully. New balance: " + balance);
        } else {
            System.out.println("Cannot deposit. Account is not active.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (isActive) {
            if (hasSufficientBalance(amount)) {
                balance -= amount;
                System.out.println(amount + " withdrawn successfully. New balance: " + balance);
            } else {
                System.out.println("Insufficient balance. Withdrawal failed.");
            }
        } else {
            System.out.println("Cannot withdraw. Account is not active.");
        }
    }

    @Override
    public boolean hasSufficientBalance(double amount) {
        return (balance - amount) >= MINIMUM_BALANCE;
    }
}
