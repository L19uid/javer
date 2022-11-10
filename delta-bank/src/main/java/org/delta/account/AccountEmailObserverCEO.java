package org.delta.account;

import org.delta.observer.Observer;
import org.delta.observer.Subject;

public class AccountEmailObserverCEO implements Observer {
    @Override
    public void update(Subject content) {
        BaseAccount account = (BaseAccount) content;
        System.out.println("Sending email to CEO about account " + account.getAccountNumber());
    }
}
