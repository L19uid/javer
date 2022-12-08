package org.delta.atm;

import org.delta.account.BaseAccount;

import javax.inject.Singleton;

@Singleton
public class AtmInfoPrinterService {
    public void atmWithdraw(BaseAccount account, int amount) {
        System.out.println("Account of " + account.getOwner().getFullName() + " successfully withdrawn " + amount + " CZK.");
    }
    public void atmBalance(BaseAccount account) {
        System.out.println("Account of " + account.getOwner().getFullName() + " has " + account.getBalance() + " CZK.");
    }
    public void atmFailedWithdraw(BaseAccount account, int amount) {
        System.out.println("Account of " + account.getOwner().getFullName() + " has not enough money to withdraw " + amount + " CZK.");
    }
}
