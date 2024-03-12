package Lab9;

import java.util.Arrays;

// Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.
// Задана коллекция чисел. С помощью метода reduce вернуть сумму чисел, которые > 10

public class Variant210 {
    public static void main(String[] args) {
        Integer[] arr = { 1, 10, 2, 3, 4, 40, 5, 60, 70 };
        System.out.println("Сумма: " + Arrays.stream(arr).filter(x->x > 10).reduce(0, Integer::sum));
    }
}
