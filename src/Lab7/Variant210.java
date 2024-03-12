package Lab7;

// В тексте найти первую подстроку максимальной длины, не содержащую букв.

public class Variant210 {
    public static void main(String[] args) {
        int maxCount = 0;
        String text = "Some 2024 text with numbers 1000005!";

        for (int i = 0; i < text.length(); ++i)
        {
            if (String.valueOf(text.charAt(i)).matches("\\d"))
            {
                StringBuilder value = new StringBuilder();
                while (String.valueOf(text.charAt(i)).matches("\\d"))
                {
                    value.append(String.valueOf(text.charAt(i)));
                    ++i;
                }
                int number = Integer.parseInt(value.toString());
                if (maxCount < number) maxCount = number;
            }
        }

        System.out.println("Результат: " + maxCount);
    }
}
