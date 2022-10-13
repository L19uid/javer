package org.delta.account;

import org.delta.account.serialization.AccountJsonSerializationObject;
import org.delta.card.serialization.CardSerializationObject;
import org.delta.card.serialization.CardSerializationObjectFactory;
import org.delta.person.Person;
import org.delta.person.PersonFactory;
import java.util.List;
import java.util.LinkedList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AccountFactory {

    @Inject
    private PersonFactory personFactory;

    @Inject
    private CardSerializationObjectFactory cardSerializationObjectFactory;

    private List<BaseAccount> accounts = new LinkedList<>();

    public BaseAccount createBaseAccount(String acccountNumber, Person person, float balance) {
        return new BaseAccount(acccountNumber, person, balance);
    }

    public StudentAccount createStudentAccount(String acccountNumber, Person person, float balance) {
        return new StudentAccount(acccountNumber, person, balance);
    }

    public SavingAccount createSavingAccount(String acccountNumber, Person person, float balance) {
        return new SavingAccount(acccountNumber, person, balance);
    }
    public BaseAccount createFactoryFromJsonSerializationObject(AccountJsonSerializationObject accountJsonSerializationObject) {
        Person person = personFactory.createPersonFromSerializationObject(accountJsonSerializationObject.owner);
        BaseAccount account = createBaseAccount(accountJsonSerializationObject.accountNumber, person, accountJsonSerializationObject.balance);
        for (CardSerializationObject cardSerializationObject : accountJsonSerializationObject.cards) {
            account.addCard(cardSerializationObjectFactory.createFromJsonSerializationObject(cardSerializationObject,account));
        }
        return account;
    }

    public BaseAccount getAccountByNumber(String accountNumber) {
        if(accounts.stream().anyMatch(account -> account.getAccountNumber().equals(accountNumber))) {
            return accounts.stream().filter(account -> account.getAccountNumber().equals(accountNumber)).findFirst().get();
        }
        return null;
    }

    public void addAccount(BaseAccount account) {
        accounts.add(account);
    }
}
