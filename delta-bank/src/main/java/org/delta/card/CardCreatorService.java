package org.delta.card;

import org.delta.account.BaseAccount;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CardCreatorService {

    @Inject
    private CardFactory cardFactory;

    @Inject
    public CardDataGeneratorService CardDGS;

    public void createCardAndSetIntoAccount(BaseAccount baseAccount) {

        String cardNumber = this.CardDGS.generateCardNumber();
        String expiration = this.CardDGS.generateExpirationDate();
        String cvc = this.CardDGS.generateCVC();

        BaseCard card = this.cardFactory.createBaseCard(baseAccount, cardNumber, expiration, cvc);
        baseAccount.addCard(card);
    }

}
