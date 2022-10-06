package org.delta.account.serialization;

import org.delta.account.AccountType;
import org.delta.account.BaseAccount;
import org.delta.card.serialization.CardSerializationObjectFactory;
import org.delta.person.serialization.PersonSerializationObjectFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AccountJsonSerializationFactory {

    @Inject
    private PersonSerializationObjectFactory personFactory;

    public AccountJsonSerializationObject createFromBaseAccount(BaseAccount baseAccount) {
        AccountJsonSerializationObject accountJsonSerializationObject = new AccountJsonSerializationObject();
        accountJsonSerializationObject.accountType = AccountType.GetType(baseAccount);
        accountJsonSerializationObject.accountNumber = baseAccount.getAccountNumber();
        accountJsonSerializationObject.balance = baseAccount.getBalance();
        accountJsonSerializationObject.owner = personFactory.createFromPerson(baseAccount.getOwner());
        accountJsonSerializationObject.cards = CardSerializationObjectFactory.createFromBaseAccount(baseAccount);

        return accountJsonSerializationObject;
    }
}
