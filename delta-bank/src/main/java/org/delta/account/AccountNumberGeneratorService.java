package org.delta.account;

import com.google.inject.Singleton;

import java.util.Random;

@Singleton
public class AccountNumberGeneratorService {
    public String generateAccountNumber()
    {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++)
        {
            sb.append(random.nextInt(9999));
            if(i<3) sb.append("-");
        }

        return sb.toString();
    }
}
