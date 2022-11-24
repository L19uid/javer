package org.delta.account;

import org.delta.observer.Observer;
import org.delta.observer.Subject;

public class AccountEmailObserverUser implements Observer {
    @Override
    public void update(Subject content) {
        System.out.println("Sending email to  about account " + content);
    }
}
