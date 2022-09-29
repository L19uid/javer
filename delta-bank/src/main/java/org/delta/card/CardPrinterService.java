package org.delta.card;

import com.google.inject.Singleton;
import org.delta.account.BaseAccount;

import java.util.List;

@Singleton
public class CardPrinterService {
    public void printAllCards(BaseAccount account)
    {
        System.out.println("Účet zákazníka " + account.getOwner().getFullName() + " má " + account.getCardCount() + " karet.");
        if(account.getCardCount() > 0)
        {
            List<BaseCard> cards = account.getCards();
            for(BaseCard card :cards)
            {
                System.out.println("Karta zákazníka " + account.getOwner().getFullName() + " má číslo "+ card.getCardNumber() + " s datumem expirace " + card.getExpiration() + " má cvc " + card.getCvc());
            }
        }

    }
}
