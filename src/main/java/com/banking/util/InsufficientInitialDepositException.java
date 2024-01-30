package main.java.com.banking.util;

public class InsufficientInitialDepositException extends Exception {
    public InsufficientInitialDepositException(String message) {
        super(message);
        UniqueAccountNumberGenerator.decrementCount(); //exception in creating account shouldn't waste account number values
    }
}
