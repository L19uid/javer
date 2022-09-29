package org.delta.account;

import org.delta.person.Person;

public class SavingAccount extends BaseAccount implements AccountWithInterest {

    public SavingAccount(String acccountNumber, Person owner, float balance) {
        super(acccountNumber, owner, balance);
    }

    @Override
    public float getInterest() {
        return 5;
    }
}
