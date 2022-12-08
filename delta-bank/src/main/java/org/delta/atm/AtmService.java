package org.delta.atm;

import org.delta.card.BaseCard;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class AtmService {

    @Inject AtmInfoPrinterService atmInfoPrinterService;

    public List<Atm> atms = new LinkedList<>();

    public List<Atm> getAtms() {
        return atms;
    }
    public void withdraw(Atm atm, BaseCard card, int amount) {
        if(card.getBaseAccount().getBalance() >= amount) {
            atm.withdraw(card,amount);
            atmInfoPrinterService.atmWithdraw(card.getBaseAccount(), amount);
        }
        else {
            atmInfoPrinterService.atmFailedWithdraw(card.getBaseAccount(),amount);
        }
    }
    public void Balance(BaseCard card) {
        atmInfoPrinterService.atmBalance(card.getBaseAccount());
    }
}
