package org.delta;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.log4j.BasicConfigurator;
import org.delta.notification.persons.NotifyCustomerEvent;
import org.delta.notification.persons.NotifyCustomerEventListener;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BankInjector());

        Bank bank = injector.getInstance(Bank.class);

        injector.getInstance(NotifyCustomerEventListener.class);

        bank.StartTerminal();

        //Bank bank = new Bank();
        //bank.startTerminal();
        //bank.example();

    }
}