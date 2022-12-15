package org.delta.card;

import org.delta.account.BaseAccount;

import javax.inject.Inject;

public class CreditCardCreatorService {
    @Inject
    private CreditCardFactory creditCardFactory;

    @Inject
    public CardDataGeneratorService CardDGS;

    public void createCardAndSetIntoAccount(BaseAccount baseAccount) {

        String cardNumber = this.CardDGS.generateCardNumber();
        String expiration = this.CardDGS.generateExpirationDate();
        String cvc = this.CardDGS.generateCVC();

        CreditCard card = this.creditCardFactory.createCreditCard(baseAccount, cardNumber, expiration, cvc);
        baseAccount.addCreditCard(card);
    }
}
