package org.delta.observer;

import java.util.ArrayList;
import java.util.List;

public interface Subject {
    List<Observer> observers = new ArrayList<Observer>();

    void addObserver(Observer o);
    void notifyObservers();
    void removeObserver(Observer o);
}
