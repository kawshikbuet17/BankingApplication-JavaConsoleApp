package main.java.com.singleton;

import main.java.com.banking.account.Account;
import main.java.com.builder.AccountBuilder;
import main.java.com.builder.AccountDirector;
import main.java.com.banking.account.AccountType;
import main.java.com.builder.ConcreteAccountBuilder;

import java.util.HashMap;
import java.util.Map;

public class BankImpl implements Bank {
    private final Map<String, Account> accounts;

    public BankImpl() {
        this.accounts = new HashMap<>();
    }

    @Override
    public void createAccount(String accountName, double initialBalance, AccountType accountType) {
        AccountBuilder accountBuilder = new ConcreteAccountBuilder();
        AccountDirector accountDirector = new AccountDirector(accountBuilder);
        Account newAccount = accountDirector.construct(accountName, initialBalance, accountType);

        if (newAccount != null) {
            accounts.put(newAccount.getAccountNumber(), newAccount);
            System.out.println("Account created successfully.");
            newAccount.displayInfo();
        } else {
            System.out.println("Failed to create account.");
        }
    }

    @Override
    public void displayAllAccounts() {
        System.out.println("All Accounts:");
        for (Account account : accounts.values()) {
            account.displayInfo();
            System.out.println("------------------------------");
        }
    }

    @Override
    public void updateAccount(String accountNumber, String updatedName) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            if(account.updateAccountName(updatedName)){
                System.out.println("Account updated successfully.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    @Override
    public void deleteAccount(String accountNumber) {
        Account account = accounts.remove(accountNumber);
        if (account != null) {
            if(account.deleteAccount()){
                System.out.println("Account deleted successfully.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    @Override
    public void depositAmount(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    @Override
    public void withdrawAmount(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    @Override
    public void searchAccount(String accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Account found:");
            account.displayInfo();
        } else {
            System.out.println("Account not found.");
        }
    }
}
