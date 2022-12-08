package org.delta.card;

import com.google.inject.Guice;
import com.google.inject.Inject;
import org.delta.BankInjector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardCreatorServiceTest {

    @Inject
    CardCreatorService cardCreatorService;

    @BeforeEach
    public void setUp()
    {
        Guice.createInjector(new BankInjector()).injectMembers(this);
    }

    @Test
    void testInjectbaseService() throws Exception{
        assertNotNull(this.cardCreatorService);
        assertInstanceOf(CardCreatorService.class, this.cardCreatorService);
    }

    @Test
    public void testAreServicesInjected() throws Exception{
        assertNotNull(this.cardCreatorService);
        assertInstanceOf(CardCreatorService.class, this.cardCreatorService);
        assertInstanceOf(CardDataGeneratorService.class, this.cardCreatorService.CardDGS);
    }
}