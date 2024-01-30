package main.java.com.banking.factory;

import main.java.com.banking.account.Account;
import main.java.com.banking.util.InsufficientInitialDepositException;
import main.java.com.banking.util.UniqueAccountNumberGenerator;

import java.util.Date;

public abstract class AccountAbstractFactory {
    public abstract Account createAccount(String accountName, Date creationDate, double initialBalance) throws InsufficientInitialDepositException;

    protected String generateUniqueAccountNumber() {
        return UniqueAccountNumberGenerator.generateIncrementalAccountNumber();
    }
}