package org.delta.card;

import com.google.inject.Singleton;

@Singleton
public class CreditCardService {
    public void creditCardWithdraw(CreditCard creditCard, float amount) {
        creditCardLooseDays(creditCard, 1);
        if (amount > creditCard.getCreditLimit()) {
            System.out.println("Credit limit exceeded");
        } else {
            creditCard.creditLimit -= amount;
        }
    }

    public void creditCardRecover(CreditCard creditCard, float amount) {
        creditCardLooseDays(creditCard, 1);
        creditCard.creditLimit += amount;
    }


    public void creditCardLooseDays(CreditCard creditCard, float days) {
        if(creditCard.creditRecoveryDays > 0) {
            creditCard.creditRecoveryDays -= days;
        }
        else
        {
            System.out.println("Credit days exceeded");
        }
    }
}
