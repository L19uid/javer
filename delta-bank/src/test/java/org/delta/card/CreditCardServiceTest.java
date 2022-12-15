package org.delta.card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardServiceTest {

        @Test
        void creditCardWithdraw() {
            CreditCardService creditCardService = new CreditCardService();
            CreditCard creditCard = new CreditCard(null, "1234567890123456", "12/2020", "123", 40f, 10000f);
            creditCardService.creditCardWithdraw(creditCard, 1000);
            assertEquals(creditCard.getCreditLimit(), 9000f);
        }

}