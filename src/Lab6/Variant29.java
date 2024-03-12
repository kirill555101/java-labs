package Lab6;

import java.util.Stack;

// Дана матрица из целых чисел. Найти в ней прямоугольную подматрицу, состоящую из максимального количества одинаковых элементов. Использовать класс Stack.

public class Variant29 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 0, 1, 0, 1},
                {3, 2, 2, 2, 3},
                {4, 2, 2, 2, 4},
                {5, 2, 2, 2, 5},
                {1, 0, 1, 0, 1},
        };
        Stack<Integer> stack = new Stack<Integer>();

        int n = 5, currentXCount = 0, maxCount = 0;
        var firstLine = true;

        for (int oy = 0; oy < n; ++oy) { // Сдвиг по OY
            for (int ox = 0; ox < n; ++ox) { // Сдвиг по OX
                for (int i = oy; i < n; ++i) {
                    if (stack.empty()) {
                        stack.push(matrix[i][ox]);
                    } else {
                        var elem = stack.pop();
                        stack.push(elem);
                        if (matrix[i][ox] == elem) stack.push(matrix[i][ox]);
                    }

                    var XCount = 0;
                    var validLine = true;

                    for (int j = ox + 1; j < n; ++j) {
                        var elem = stack.pop();
                        stack.push(elem);

                        if (XCount == currentXCount && !firstLine) break;
                        if (elem != matrix[i][j]) {
                            validLine = firstLine;
                            break;
                        }

                        if (firstLine) {
                            ++currentXCount;
                        } else {
                            ++XCount;
                        }

                        stack.push(elem);
                    }

                    if (!validLine) break;
                    if (stack.size() >= maxCount) maxCount = stack.size();
                    firstLine = false;
                }

                firstLine = true;
                currentXCount = 0;
                stack.clear();
            }
        }

        System.out.println("Найдена максимальная прямоугольная подматрица размером: " + maxCount);
    }
}
