package org.delta.card.serialization;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.account.BaseAccount;
import org.delta.card.BaseCard;
import org.delta.card.CreditCard;
import org.delta.card.CreditCardFactory;

import java.util.LinkedList;
import java.util.List;

@Singleton
public class CreditCardSerializationFactory {

    @Inject
    CreditCardFactory creditCardFactory;
    public static CreditCardSerializationObject createFromCard(CreditCard card) {
        CreditCardSerializationObject cardSerializationObject = new CreditCardSerializationObject();
        cardSerializationObject.cardNumber = card.getCardNumber();
        cardSerializationObject.expiration = card.getExpiration();
        cardSerializationObject.cvc = card.getCvc();
        cardSerializationObject.creditLimit = card.getCreditLimit();
        cardSerializationObject.creditRecoveryDays = card.getCreditRecoveryDays();
        return cardSerializationObject;
    }

    public static List<CreditCardSerializationObject> createFromBaseAccount(BaseAccount baseAccount) {
        List<CreditCardSerializationObject> cardSerializationObjects = new LinkedList<>();

        for (CreditCard card : baseAccount.getCreditCards()) {
            cardSerializationObjects.add(createFromCard(card));
        }
        return cardSerializationObjects;
    }

    public BaseCard createFromJsonSerializationObject(CreditCardSerializationObject object, BaseAccount baseAccount) {
        CreditCard card = new CreditCard(baseAccount,object.cardNumber, object.expiration, object.cvc,object.creditRecoveryDays,object.creditLimit);
        return card;
    }
}
