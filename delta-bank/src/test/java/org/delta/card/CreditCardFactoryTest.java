package org.delta.card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardFactoryTest {

    @Test
    void createCreditCard() {
        CreditCardFactory creditCardFactory = new CreditCardFactory();
        CreditCard creditCard = creditCardFactory.createCreditCard(null, "1234567890123456", "12/2020", "123");
        assertEquals(creditCard.getCreditLimit(), 10000f);
        assertEquals(creditCard.getCreditRecoveryDays(), 40f);
    }
}