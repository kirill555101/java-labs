package Lab2;

import java.util.Scanner;

// Ввести с консоли n – размерность матрицы a[n][n].
// Задать значения элементов матрицы в интервале значений от -n до n
// с помощью датчика случайных чисел. Вычислить определитель матрицы.

public class Variant28 {
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
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                System.out.printf("%.2f ", matrix[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.printf("Определитель: %.2f", det(matrix));
    }

    public static double det(double[][] m) {
        if (m.length == 1) {
            return m[0][0];
        }
        if (m.length == 2) {
            return m[0][0] * m[1][1] - m[0][1] * m[1][0];
        }

        int sign = 1;
        double sum = 0;
        double[][] temp = new double[m.length - 1][m.length - 1];
        for (int t = 0; t < m.length; ++t) {
            for (int i = 1; i < m.length; ++i) {
                int newJ = 0;
                for (int j = 0; j < m.length; ++j) {
                    if (j == t) {
                        continue;
                    }

                    temp[i - 1][newJ++] = m[i][j];
                }
            }

            sum += sign * m[0][t] * det(temp);
            sign *= -1;
        }

        temp = null;
        return sum;
    }
}
