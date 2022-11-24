package org.delta.account;

import org.delta.card.CardPrinterService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AccountInfoPrinterService {
    @Inject
    private CardPrinterService cardPS;
    public void printAccountInfo(BaseAccount account) {
        System.out.println(this.getTypePrefix(account) + "Balance of " + account.getOwner().getFullName() + " account is " + account.getBalance() + ", number of cards: " + account.getCardCount() + " account number of " + account.getAccountNumber());
        cardPS.printAllCards(account);
    }

    private String getTypePrefix(BaseAccount account) {
        if (account instanceof StudentAccount) {
            return "[Student] ";
        }

        if (account instanceof SavingAccount) {
            return "[Saving] ";
        }

        return "[Base] ";
    }
}
