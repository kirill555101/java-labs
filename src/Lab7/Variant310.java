package Lab7;

import java.util.*;
import java.util.function.Function;

// Рассортировать слова русского текста по возрастанию доли гласных букв
// (отношение количества гласных к общему количеству букв в слове).

public class Variant310 {
    public static void main(String[] args) {
        var text = "Аа1 Бб2 Вв1 Бв3 Бб1 Аа2";
        var list = new ArrayList<String>(List.of(text.split(" ")));

        // Функция, возвращающая количество гласных букв
        Function<String, Integer> getCount = new Function<String, Integer>() {
            // Коллекция, содержащая гласные буквы
            private final Set<Character> set = new HashSet<>(Arrays.asList('а', 'е', 'у', 'ы', 'о', 'я'));

            @Override
            public Integer apply(String s) {
                var count = 0;
                for (int i = 0; i < s.length(); ++i) {
                    count += set.contains(s.toLowerCase().charAt(i)) ? 1 : 0;
                }

                return count;
            }
        };

        // Сортировка по возврастанию частоты гласных букв
        Comparator<String> comparator = (s1, s2) -> Integer.compare(getCount.apply(s1), getCount.apply(s2));
        Collections.sort(list, comparator);

        System.out.print("Результат: ");
        for (var word : list) {
            System.out.print(word + " ");
        }
    }
}
