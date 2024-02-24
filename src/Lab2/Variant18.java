package Lab2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// В приведенных ниже заданиях необходимо вывести внизу фамилию разработчика,
// дату и время получения задания, а также дату и время сдачи задания.
// Для получения последней даты и времени следует использовать класс Date.
// Ввести n слов с консоли. Среди слов, состоящих только из цифр, найти слово-палиндром.
// Если таких слов больше одного, найти второе из них.

public class Variant18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите количество элементов: ");
        int size = input.nextInt();
        String[] arr = new String[size];
        System.out.print("Введите массив: ");
        for (int i = 0; i < size; i++) {
            arr[i] = input.next();
        }

        String result = "";
        for (int i = 0; i < size; i++) {
            if (isNumber(arr[i]) && isPalindrome(arr[i])) {
                if (!result.isEmpty()) {
                    result = arr[i];
                    break;
                }

                result = arr[i];
            }
        }

        if (result.isEmpty()) {
            System.out.println("Слово не найдено");
        } else {
            System.out.println("Результат: " + result);
        }

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        System.out.println("Фамилия: Каташинский");
        System.out.println("Дата сдачи: " + formatter.format(date));
    }

    private static boolean isNumber(String word) {
        return word.matches("[0-9]+");
    }

    private static boolean isPalindrome(String word) {
        return word.contentEquals(new StringBuilder(word).reverse());
    }
}
