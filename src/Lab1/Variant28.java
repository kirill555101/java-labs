package Lab1;

import java.util.Scanner;

// Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести: простые числа.

public class Variant28 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите количество элементов: ");
        int size = input.nextInt();
        int[] arr = new int[size];
        System.out.print("Введите массив: ");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        System.out.print("Простые числа: ");
        for (int i = 0; i < size; i++) {
            if (!isPrime(arr[i])) {
                continue;
            }

            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static boolean isPrime(int n) {
        var sqrt = Math.round((Math.sqrt((n))));

        for (int i = 2; i <= sqrt; ++i) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
