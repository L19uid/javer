package org.delta.card;

import org.delta.account.BaseAccount;

public class CreditCard extends BaseCard {

    public float creditRecoveryDays = 40f;
    public float creditLimit = 10000f;

    public CreditCard(BaseAccount baseAccount, String cardNumber, String expiration, String cvc, float creditRecoveryDays, float creditLimit) {
        super(baseAccount, cardNumber, expiration, cvc);
        this.creditRecoveryDays = creditRecoveryDays;
        this.creditLimit = creditLimit;
    }

    public float getCreditRecoveryDays()
    {
        return creditRecoveryDays;
    }
    public float getCreditLimit()
    {
        return creditLimit;
    }
}
