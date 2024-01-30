package main.java.com.banking.factory;

import main.java.com.banking.account.Account;
import main.java.com.banking.account.CurrentAccount;
import main.java.com.banking.util.InsufficientInitialDepositException;

import java.util.Date;

public class CurrentAccountFactory extends AccountAbstractFactory {
    @Override
    public Account createAccount(String accountName, Date creationDate, double initialBalance) throws InsufficientInitialDepositException {
        String uniqueAccountNumber = generateUniqueAccountNumber();
        return new CurrentAccount(accountName, uniqueAccountNumber, creationDate, initialBalance);
    }
}
