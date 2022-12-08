package org.delta.card;

import com.google.inject.Singleton;

import java.util.Calendar;
import java.util.Random;

@Singleton
public class CardDataGeneratorService {
    public String generateCardNumber()
    {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int x = 0;x<4;x++)
        {
            for (int y = 0;y<3;y++)
            {
                sb.append(random.nextInt(9));
            }
            if(x <3)sb.append("-");
        }
        return sb.toString();
    }
    public String generateCVC()
    {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int y = 0;y<3;y++)
        {
            sb.append(random.nextInt(9));
        }
        return sb.toString();
    }
    public String generateExpirationDate()
    {
        Calendar c = Calendar.getInstance();
        StringBuilder sb = new StringBuilder();

        int year = c.get(Calendar.YEAR) + 5;
        int month = c.get(Calendar.MONTH);

        sb.append(year-2000 + "/" + month);

        return sb.toString();
    }
}
