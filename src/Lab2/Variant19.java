package Lab2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// В приведенных ниже заданиях необходимо вывести внизу фамилию разработчика,
// дату и время получения задания, а также дату и время сдачи задания.
// Для получения последней даты и времени следует использовать класс Date.
// Используя оператор switch, написать программу,
// которая выводит на экран сообщения о принадлежности некоторого значения k интервалам
// (-10k, 0], (0, 5], (5, 10], (10, 10k].

public class Variant19 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите k: ");
        int k = input.nextInt();

        switch (Boolean.toString(10*k < k && k <= 0)) {
            case "true": {
                System.out.println("Принадлежит (-10k, 0]");
                break;
            }
            case "false": {
                System.out.println("Не принадлежит (-10k, 0]");
                break;
            }
        }

        switch (Boolean.toString(0 < k && k <= 5)) {
            case "true": {
                System.out.println("Принадлежит (0, 5]");
                break;
            }
            case "false": {
                System.out.println("Не принадлежит (0, 5]");
                break;
            }
        }

        switch (Boolean.toString(5 < k && k <= 10)) {
            case "true": {
                System.out.println("Принадлежит (5, 10]");
                break;
            }
            case "false": {
                System.out.println("Не принадлежит (5, 10]");
                break;
            }
        }

        switch (Boolean.toString(10 < k && k <= 10*k)) {
            case "true": {
                System.out.println("Принадлежит (10, 10k]");
                break;
            }
            case "false": {
                System.out.println("Не принадлежит (10, 10k]");
                break;
            }
        }

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        System.out.println("Фамилия: Каташинский");
        System.out.println("Дата сдачи: " + formatter.format(date));
    }
}
