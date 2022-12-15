package org.delta.atm;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.card.BaseCard;
import org.delta.card.CreditCard;
import org.delta.card.CreditCardService;

public class Atm {
    @Inject
    CreditCardService creditCardService;

    public void withdraw(BaseCard card, int amount) {
        card.getBaseAccount().subFromBalance(amount);
    }

    public void withdrawCredit(CreditCard card, int amount) {
        creditCardService.creditCardWithdraw(card, amount);
    }
}
