package org.delta.account;

import com.google.common.eventbus.EventBus;
import org.delta.account.serialization.AccountJsonSerializationObject;
import org.delta.notification.persons.NotificationData;
import org.delta.notification.persons.NotifyCustomerEvent;
import org.delta.person.Person;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class AccountService {
    @Inject
    private AccountFactory accountFactory;

    @Inject
    EventBus eventBus;

    @Inject
    private AccountNumberGeneratorService accountNGS;

    private final Map<String,BaseAccount> accounts = new HashMap<>();

    public BaseAccount createAccount(AccountType accountType, Person person, float balance) {
        String accountNumber = this.accountNGS.generateAccountNumber();
        emailAccount(accountNumber, person);
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

    private void emailAccount(String accountNumber, Person person) {
        eventBus.post(new NotifyCustomerEvent(new NotificationData(accountNumber, person.getFullName())));
        AccountEmailSubject accountEmailSubject = new AccountEmailSubject();
        accountEmailSubject.addObserver(new AccountEmailObserverUser());
        accountEmailSubject.addObserver(new AccountEmailObserverCEO());
        accountEmailSubject.notifyObservers();
        accountEmailSubject.removeObservers();
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
