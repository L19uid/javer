package org.delta.account;

import org.delta.person.Person;

import javax.inject.Singleton;

@Singleton
public class AccountFactory {

    public BaseAccount createBaseAccount(String acccountNumber, Person person, float balance) {
        return new BaseAccount(acccountNumber, person, balance);
    }

    public StudentAccount createStudentAccount(String acccountNumber, Person person, float balance) {
        return new StudentAccount(acccountNumber, person, balance);
    }

    public SavingAccount createSavingAccount(String acccountNumber, Person person, float balance) {
        return new SavingAccount(acccountNumber, person, balance);
    }
}
