package org.delta.card;

public class CardDataGeneratorServiceMock extends CardDataGeneratorService{

    @Override
    public String generateCardNumber()
    {
        return "123-456-789-000";
    }
}
