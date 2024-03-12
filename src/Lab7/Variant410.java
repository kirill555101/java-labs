package Lab7;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

// Исключить из текста подстроку максимальной длины, начинающуюся и заканчивающуюся одним и тем же символом.

public class Variant410
{
    public static void main(String[] args)
    {
        String text = "а+а а++а +а+++а+ ++а++++а++";
        String regexPattern = "(?<=а)\\S+(?=а)";

        int maxLength = 0, startIndex = -1, endIndex = -1;
        Matcher matcher = Pattern.compile(regexPattern).matcher(text);
        while (matcher.find()) {
            var length = matcher.end() - matcher.start();
            if (length > maxLength) {
                startIndex = matcher.start();
                endIndex = matcher.end();
            }
        }

        if (startIndex > 0) {
            text = text.substring(0, startIndex) + text.substring(endIndex);
        }
        System.out.println("Результат: " + text);
    }
}
