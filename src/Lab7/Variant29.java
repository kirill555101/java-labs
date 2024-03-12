package Lab7;

// В стихотворении найти одинаковые буквы, которые встречаются во всех словах.

public class Variant29 {
    public static void main(String[] args) {
        String[] words = "Очень интересное крупное здание".split(" ");
        boolean contains = true;

        System.out.print("Результат: ");
        for (int i = 0; i < words[0].length(); ++i) {
            contains = true;

            for (int j = 1; j < words.length; ++j) {
                contains &= words[j].contains(String.valueOf(words[0].charAt(i)));
            }

            if (contains) System.out.print(words[0].charAt(i) + " ");
        }
    }
}
