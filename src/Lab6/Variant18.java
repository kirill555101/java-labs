package Lab6;

import java.util.Scanner;
import java.util.Stack;

// Задана строка, состоящая из символов '(', ')', '[', ']', '{', '}'. Проверить правильность расстановки скобок. Использовать стек.

public class Variant18 {
    public static void main(String[] args) {
        System.out.print("Введите строку: ");
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        var stack = new Stack<Character>();

        for (int i = 0; i < line.length(); ++i) {
            var symbol = line.charAt(i);
            if (symbol == '(' || symbol == '[' || symbol == '{') {
                stack.push(symbol);
                continue;
            }

            var elem = stack.pop();
            if (elem == '(' && symbol == ')') continue;
            if (elem == '[' && symbol == ']') continue;
            if (elem == '{' && symbol == '}') continue;

            stack.push(elem);
        }

        if (stack.isEmpty()) {
            System.out.println("Результат: строка верная");
        } else {
            System.out.println("Результат: строка неверная");
        }
    }
}
