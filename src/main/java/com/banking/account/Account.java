package main.java.com.banking.account;

public interface Account {
    void displayInfo();
    AccountType getAccountType();
    String getAccountNumber();
    boolean updateAccountName(String updatedName);
    boolean deleteAccount();
    void deposit(double amount);
    void withdraw(double amount);
    boolean hasSufficientBalance(double amount);
}
