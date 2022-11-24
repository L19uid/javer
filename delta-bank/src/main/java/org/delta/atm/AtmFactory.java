package org.delta.atm;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.LinkedList;
import java.util.List;

public class AtmFactory {

    @Inject AtmSorageService atmSorageService;

    @Singleton
    public Atm createAtm() {
        return new Atm();
    }
}
