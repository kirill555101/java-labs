package Lab2;

import java.util.Scanner;

// Ввести с консоли n – размерность матрицы a[n][n].
// Задать значения элементов матрицы в интервале значений от -n до n
// с помощью датчика случайных чисел. Построить матрицу,
// вычитая из элементов каждой строки матрицы ее среднее арифметическое.

public class Variant29 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите размер матрицы: ");
        int size = input.nextInt();

        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                matrix[i][j] = (Math.random() * (2 * size + 1)) - size;
            }
        }

        System.out.println("Матрица: ");
        double sum = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                sum += matrix[i][j];
                System.out.printf("%.2f ", matrix[i][j]);
            }
            System.out.println();
        }

        double avg = sum / (size * size);
        System.out.println();
        System.out.println("Итоговая матрица: ");
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                System.out.printf("%.2f ", matrix[i][j] - avg);
            }
            System.out.println();
        }
    }
}
