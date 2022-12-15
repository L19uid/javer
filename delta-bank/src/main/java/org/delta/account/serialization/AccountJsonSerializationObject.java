package org.delta.account.serialization;

import com.google.gson.annotations.SerializedName;
import org.delta.account.AccountType;
import org.delta.card.serialization.CardSerializationObject;
import org.delta.card.serialization.CreditCardSerializationFactory;
import org.delta.card.serialization.CreditCardSerializationObject;
import org.delta.person.serialization.PersonSerializationObject;

import java.util.List;

public class AccountJsonSerializationObject {
    public String accountNumber;

    @SerializedName("owner")
    public PersonSerializationObject owner;

    public float balance;

    public AccountType accountType;

    @SerializedName("cards")
    public List<CardSerializationObject> cards;
    @SerializedName("credit cards")
    public List<CreditCardSerializationObject> creditCards;
}
