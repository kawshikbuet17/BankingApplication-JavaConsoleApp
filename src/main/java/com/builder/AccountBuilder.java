package main.java.com.builder;

import main.java.com.banking.account.Account;
import main.java.com.banking.account.AccountType;

public interface AccountBuilder {
    AccountBuilder setName(String accountName);
    AccountBuilder setCreationDate();
    AccountBuilder setInitialBalance(double initialBalance);
    AccountBuilder setAccountType(AccountType accountType);
    Account build();
}
