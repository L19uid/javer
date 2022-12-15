package org.delta.card;

import org.delta.account.BaseAccount;
import org.delta.card.CreditCard;

public class CreditCardFactory {

        public CreditCard createCreditCard(BaseAccount baseAccount, String cardNumber, String expiration, String cvc) {
            return new CreditCard(baseAccount, cardNumber, expiration, cvc, 40f, 10000f);
        }
}
