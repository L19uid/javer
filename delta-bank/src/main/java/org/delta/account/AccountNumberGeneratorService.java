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
            for(int j = 0; j < 3; j++)
            {
                sb.append(random.nextInt(9));
            }
            if(i<3) sb.append("-");
        }

        return sb.toString();
    }
}
