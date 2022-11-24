package org.delta.atm;

import org.delta.account.BaseAccount;

import javax.inject.Singleton;

public class AtmInfoPrinterService {
    @Singleton
    public void atmWithdraw(BaseAccount account, int amount) {
        System.out.println("Account of " + account.getOwner().getFullName() + " successfully withdrawn " + amount + " CZK.");
    }
    @Singleton
    public void atmBalance(BaseAccount account) {
        System.out.println("Account of " + account.getOwner().getFullName() + " has " + account.getBalance() + " CZK.");
    }
    @Singleton
    public void atmFailedWithdraw(BaseAccount account, int amount) {
        System.out.println("Account of " + account.getOwner().getFullName() + " has not enough money to withdraw " + amount + " CZK.");
    }
}
