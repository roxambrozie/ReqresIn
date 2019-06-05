package utils.strings;

import java.util.Random;

public class StringUtils {
    public static String getRandomValue(){
        Random random = new Random();
        int randomInt = random.nextInt();
        return Integer.toString(randomInt);
    }
}
