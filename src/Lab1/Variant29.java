package Lab1;

import java.util.Scanner;

// Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести:
// отсортированные числа в порядке возрастания и убывания.

public class Variant29 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите количество элементов: ");
        int size = input.nextInt();
        int[] arr = new int[size];
        System.out.print("Введите массив: ");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        sort(arr, true);
        System.out.print("Отсортированный массив по возрастанию: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        sort(arr, false);
        System.out.print("Отсортированный массив по убыванию: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Bubble sort
    private static void sort(int[] arr, boolean increase) {
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = 0; j < arr.length - i - 1; ++j) {
                if (increase && arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

                if (!increase && arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
