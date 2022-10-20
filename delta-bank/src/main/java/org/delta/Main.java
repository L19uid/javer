package org.delta;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) {



        Injector injector = Guice.createInjector(new BankInjector());

        Bank bank = injector.getInstance(Bank.class);
        bank.StartTerminal();

        //Bank bank = new Bank();
        //bank.startTerminal();
        //bank.example();

    }
}