package Lab9;

import java.util.Arrays;
import java.util.stream.Collectors;

// Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.
// Задана коллекция чисел. С помощью метода reduce вернуть максимум и минимум.

public class Variant29 {
    public static void main(String[] args) {
        Integer[] arr = { 1, 10, 2, 3, 4, 40, 5, 60, 70 };
        var stats = Arrays.stream(arr).collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println("Максимум: " + stats.getMax());
        System.out.println("Минимум: " + stats.getMin());
    }
}
