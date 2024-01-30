package main.java.com.builder;

import main.java.com.banking.account.Account;
import main.java.com.banking.account.AccountType;

public class AccountDirector {
    private final AccountBuilder accountBuilder;

    public AccountDirector(AccountBuilder accountBuilder) {
        this.accountBuilder = accountBuilder;
    }

    public Account construct(String accountName, double initialBalance, AccountType accountType) {
        return accountBuilder
                .setName(accountName)
                .setCreationDate()
                .setInitialBalance(initialBalance)
                .setAccountType(accountType)
                .build();
    }
}
