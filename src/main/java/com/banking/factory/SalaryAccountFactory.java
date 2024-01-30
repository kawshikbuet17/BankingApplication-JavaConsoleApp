package main.java.com.banking.factory;

import main.java.com.banking.account.Account;
import main.java.com.banking.util.InsufficientInitialDepositException;
import main.java.com.banking.account.SalaryAccount;

import java.util.Date;

public class SalaryAccountFactory extends AccountAbstractFactory {
    @Override
    public Account createAccount(String accountName, Date creationDate, double initialBalance) throws InsufficientInitialDepositException {
        String uniqueAccountNumber = generateUniqueAccountNumber();
        return new SalaryAccount(accountName, uniqueAccountNumber, creationDate, initialBalance);
    }
}
