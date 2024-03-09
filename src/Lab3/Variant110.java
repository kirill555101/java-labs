package Lab3;

// Определить класс Булева матрица (BoolMatrix) размерности (n x m).
// Класс должен содержать несколько конструкторов.
// Реализовать методы для логического сложения (дизъюнкции), умножения и инверсии матриц.
// Реализовать методы для подсчета числа единиц в матрице и упорядочения строк в лексикографическом порядке

class BinaryMatrix {
    private int n, m;
    private boolean[][] matrix;

    public BinaryMatrix(boolean[][] matrix, int n, int m) {
        this.matrix = matrix;
        this.n = n;
        this.m = m;
    }

    public BinaryMatrix(int n, int m) {
        this.matrix = new boolean[n][m];
    }

    public boolean[][] get() {
        return this.matrix;
    }

    public void sum(BinaryMatrix bm) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (!this.matrix[i][j] && !bm.matrix[i][j]) {
                    this.matrix[i][j] = false;
                    continue;
                }

                this.matrix[i][j] = true;
            }
        }
    }

    public void multiply(BinaryMatrix bm) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (this.matrix[i][j] && bm.matrix[i][j]) {
                    this.matrix[i][j] = true;
                    continue;
                }

                this.matrix[i][j] = false;
            }
        }
    }

    public void inverse() {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                this.matrix[i][j] = !this.matrix[i][j];
            }
        }
    }

    public int countTrue() {
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (this.matrix[i][j]) {
                    ++count;
                }
            }
        }
        return count;
    }

    public void sort() {
        // Массив количества и индекса
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (int j = 0; j < m; ++j) {
                if (this.matrix[i][j]) {
                    ++count;
                }
            }

            arr[i][0] = count;
            arr[i][1] = i;
        }

        // Bubble sort
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - i - 1; ++j) {
                if (arr[j][0] > arr[j + 1][0]) {
                    var t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }

        var newMatrix = new boolean[n][m];
        for (int i = 0; i < n; ++i) {
            var pos = arr[i][1];
            newMatrix[i] = this.matrix[pos].clone();
        }
        this.matrix = newMatrix;
    }
}

public class Variant110 {
    public static void main(String[] args) {
        BinaryMatrix bm = new BinaryMatrix(new boolean[][]{
                {true, true, true},
                {false, true, false},
                {false, false, false}
        }, 3, 3);

        bm.sort();
        var r = bm.get();
        System.out.println("Итоговая матрица: ");
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.printf(r[i][j] + " ");
            }
            System.out.println();
        }
    }
}
