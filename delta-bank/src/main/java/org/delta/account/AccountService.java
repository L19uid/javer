package org.delta.account;

import org.delta.account.serialization.AccountJsonSerializationObject;
import org.delta.person.Person;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class AccountService {
    @Inject
    private AccountFactory accountFactory;

    @Inject
    private AccountNumberGeneratorService accountNGS;

    private final Map<String,BaseAccount> accounts = new HashMap<>();

    public BaseAccount createAccount(AccountType accountType, Person person, float balance) {
        String accountNumber = this.accountNGS.generateAccountNumber();

        switch (accountType)
        {
            case BASE:
                return this.accountFactory.createBaseAccount(accountNumber,person,balance);
            case STUDENT:
                return this.accountFactory.createStudentAccount(accountNumber,person,balance);
            case SAVING:
                return this.accountFactory.createSavingAccount(accountNumber,person,balance);
        }
        return null;
    }

    public void addAccount(BaseAccount account) {
        accounts.put(account.getAccountNumber(),account);
    }

    public BaseAccount getAccountByNumber(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public BaseAccount[] getAccounts() {
        return accounts.values().toArray(new BaseAccount[0]);
    }
}
