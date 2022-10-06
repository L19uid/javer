package org.delta.account;

import org.delta.account.serialization.AccountJsonSerializationObject;
import org.delta.person.Person;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;


public class AccountService {
    @Inject
    private AccountFactory accountFactory;

    @Inject
    private AccountNumberGeneratorService accountNGS;


    private final List<BaseAccount> accounts = new LinkedList<>();

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

    public void addAccounts(BaseAccount account)
    {
        this.accounts.add(account);
    }

    public BaseAccount findAccount(String accountNumber)
    {
        for (BaseAccount account:this.accounts)
        {
            if(account.getAccountNumber() == accountNumber)
                return account;
        }
        return null;
    }

    public BaseAccount[] getAccounts()
    {
        return this.accounts.toArray(new BaseAccount[0]);
    }

    public List getAccountList()
    {
        return this.accounts;
    }
}
