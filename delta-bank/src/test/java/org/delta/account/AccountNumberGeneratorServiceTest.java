package org.delta.account;

import org.delta.card.BaseCard;
import org.delta.card.CardFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountNumberGeneratorServiceTest {

    @Test
    void generateAccountNumber() {
        AccountNumberGeneratorService accountNumberGeneratorService = new AccountNumberGeneratorService();
        String accountNumber = accountNumberGeneratorService.generateAccountNumber();
        assertNotNull(accountNumber);
        assertEquals(15, accountNumber.length());
    }
}