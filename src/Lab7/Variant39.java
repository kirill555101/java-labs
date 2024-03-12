package Lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Напечатать слова русского текста в алфавитном порядке по первой букве.
// Слова, начинающиеся с новой буквы, печатать с красной строки.

public class Variant39 {
    public static void main(String[] args) {
        var text = "Аа1 Бб2 Вв1 Бв3 Бб1 Аа2";
        var list = new ArrayList<String>(List.of(text.split(" ")));
        Collections.sort(list);

        String letter = list.getFirst().substring(0, 1);
        boolean isRedline = true;
        for (String word:list) {
            if (!word.substring(0, 1).equals(letter)) {
                isRedline = true;
                letter = word.substring(0, 1);
            }

            if (isRedline) {
                System.out.println("\t"+word);
            } else {
                System.out.println(word);
            }

            isRedline = false;
        }
    }
}
