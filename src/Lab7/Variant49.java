package Lab7;

import java.util.ArrayList;
import java.util.List;

// Преобразовать каждое слово в тексте, удалив из него все последующие (предыдущие)
// вхождения первой (последней) буквы этого слова

public class Variant49 {
    public static void main(String[] args) {
        String text = "аbcc аbаba bvvvaa nnccaa";
        var list = new ArrayList<String>(List.of(text.split(" ")));
        var newList = new ArrayList<String>();
        for (var word : list) {
            var firstChar = word.charAt(0);
            var lastChar = word.charAt(word.length() - 1);

            var newWord = word.replaceAll(String.valueOf(firstChar), "").replaceAll(String.valueOf(lastChar), "");
            newList.add(firstChar + newWord + lastChar);
        }

        System.out.print("Результат: ");
        for (var word : newList) {
            System.out.print(word + " ");
        }
    }
}
