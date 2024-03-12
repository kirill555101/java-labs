package Lab7;

import java.util.Scanner;

// Удалить из текста его часть, заключенную между двумя символами,
// которые вводятся (например, между скобками ‘(’ и ‘)’ или между звездочками ‘*’ и т.п.).

public class Variant110 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите символ: ");
        var symbol = input.next();

        String text = "words are !equal len! two or its";
        System.out.println("Результат: " + text.replaceAll(String.format("%s.*%s", symbol, symbol), ""));
    }
}
