package org.delta.atm;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.card.BaseCard;

public class Atm {

    @Inject
    private AtmInfoPrinterService atmInfoPrinterService;
    public void withdraw(BaseCard card, int amount) {
        card.getBaseAccount().subFromBalance(amount);
    }
}
