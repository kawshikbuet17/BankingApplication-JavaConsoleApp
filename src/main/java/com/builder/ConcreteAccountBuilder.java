package main.java.com.builder;

import main.java.com.banking.account.Account;
import main.java.com.banking.account.AccountType;
import main.java.com.banking.util.InsufficientInitialDepositException;
import main.java.com.banking.factory.AccountAbstractFactory;
import main.java.com.banking.factory.CurrentAccountFactory;
import main.java.com.banking.factory.SavingsAccountFactory;
import main.java.com.banking.factory.SalaryAccountFactory;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class ConcreteAccountBuilder implements AccountBuilder {
    private String accountName;
    private Date creationDate;
    private double initialBalance;
    private AccountAbstractFactory accountFactory;

    @Override
    public AccountBuilder setName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    @Override
    public AccountBuilder setCreationDate() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        this.creationDate = Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return this;
    }

    @Override
    public AccountBuilder setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
        return this;
    }

    @Override
    public AccountBuilder setAccountType(AccountType accountType) {
        switch (accountType) {
            case CURRENT:
                this.accountFactory = new CurrentAccountFactory();
                break;
            case SAVINGS:
                this.accountFactory = new SavingsAccountFactory();
                break;
            case SALARY:
                this.accountFactory = new SalaryAccountFactory();
                break;
        }
        return this;
    }

    @Override
    public Account build() {
        try {
            return accountFactory.createAccount(accountName, creationDate, initialBalance);
        } catch (InsufficientInitialDepositException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
