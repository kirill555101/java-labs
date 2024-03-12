package Lab7;

import java.util.Scanner;

// Из текста удалить все слова заданной длины, начинающиеся на согласную букву.

public class Variant19 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите длину: ");
        int len = input.nextInt();
        String text = "words are equal len two or its";

        System.out.println("Результат: " + text.replaceAll(String.format("\\b[\\w^aeiouAEIOU]\\w{%d}\\b", len - 1), ""));
    }
}
