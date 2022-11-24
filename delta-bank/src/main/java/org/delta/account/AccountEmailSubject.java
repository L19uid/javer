package org.delta.account;

import org.delta.observer.Observer;
import org.delta.observer.Subject;

public class AccountEmailSubject implements Subject {
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void removeObservers() {
        observers.clear();
    }
}
