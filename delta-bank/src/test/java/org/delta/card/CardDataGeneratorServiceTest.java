package org.delta.card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardDataGeneratorServiceTest {

    @Test
    void generateCardNumber() {
        CardDataGeneratorService cardDataGeneratorService = new CardDataGeneratorService();
        String cardNumber = cardDataGeneratorService.generateCardNumber();
        assertNotNull(cardNumber);
        assertEquals(15, cardNumber.length());
    }

    @Test
    void generateCvc() {
        CardDataGeneratorService cardDataGeneratorService = new CardDataGeneratorService();
        String cvc = cardDataGeneratorService.generateCVC();
        assertNotNull(cvc);
        assertEquals(3, cvc.length());
    }

    @Test
    void generateExpirationDate() {
        CardDataGeneratorService cardDataGeneratorService = new CardDataGeneratorService();
        String expirationDate = cardDataGeneratorService.generateExpirationDate();
        assertNotNull(expirationDate);
        assertEquals(5, expirationDate.length());
    }
}
