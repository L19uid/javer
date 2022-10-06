package org.delta.card.serialization;

import com.google.inject.Singleton;
import org.delta.account.BaseAccount;
import org.delta.card.BaseCard;

import java.util.LinkedList;
import java.util.List;

@Singleton
public class CardSerializationObjectFactory {
    public static CardSerializationObject createFromCard(BaseCard baseCard) {
        CardSerializationObject cardSerializationObject = new CardSerializationObject();
        cardSerializationObject.cardNumber = baseCard.getCardNumber();
        cardSerializationObject.expiration = baseCard.getExpiration();
        cardSerializationObject.cvc = baseCard.getCvc();
        return cardSerializationObject;
    }
    public static List<CardSerializationObject> createFromBaseAccount(BaseAccount baseAccount) {
        List<CardSerializationObject> cardSerializationObjects = new LinkedList<>();

        for (BaseCard baseCard : baseAccount.getCards()) {
            cardSerializationObjects.add(createFromCard(baseCard));
        }
        return cardSerializationObjects;
    }

    public BaseCard createFromJsonSerializationObject(CardSerializationObject cardSerializationObject, BaseAccount baseAccount) {
        BaseCard baseCard = new BaseCard(baseAccount,cardSerializationObject.cardNumber, cardSerializationObject.expiration, cardSerializationObject.cvc);
        return baseCard;
    }
}
