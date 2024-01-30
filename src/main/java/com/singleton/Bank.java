package main.java.com.singleton;

import main.java.com.banking.account.AccountType;

public interface Bank {
    void createAccount(String accountName, double initialBalance, AccountType accountType);
    void displayAllAccounts();
    void updateAccount(String accountNumber, String updatedName);
    void deleteAccount(String accountNumber);
    void depositAmount(String accountNumber, double amount);
    void withdrawAmount(String accountNumber, double amount);
    void searchAccount(String accountNumber);
}
