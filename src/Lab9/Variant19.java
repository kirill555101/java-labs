package Lab9;

import java.util.Arrays;

// Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.
// Задана коллекция строк. Вернуть количество вхождений строки.

public class Variant19 {
    public static void main(String[] args) {
        String[] arr = { "big house", "small house", "big home", "small home" };
        String word = "house";

        System.out.println("Количество вхождений: " + Arrays.stream(arr).filter(x->x.contains(word)).count());
    }
}
