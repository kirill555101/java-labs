package Lab3;

// Определить класс Квадратное уравнение. Класс должен содержать несколько конструкторов.
// Реализовать методы для поиска корней, экстремумов, а также интервалов убывания/возрастания.
// Создать массив объектов и определить наибольшие и наименьшие по значению корни.

class BinaryEquation {
    private int[] numbers;

    public BinaryEquation(int[] numbers) {
        this.numbers = numbers;
    }

    public BinaryEquation(int a, int b, int c) {
        this.numbers = new int[]{a, b, c};
    }

    private int getD() {
        int a = numbers[0];
        int b = numbers[1];
        int c = numbers[2];

        return b * b - 4 * a * c;
    }

    public double[] search() {
        int a = numbers[0];
        int b = numbers[1];

        return new double[]{
                (-b + Math.sqrt(getD()))/(2 * a),
                (-b - Math.sqrt(getD()))/(2 * a)
        };
    }

    public double searchCenter() {
        int a = numbers[0];
        int b = numbers[1];

        return (double) -b / (2 * a);
    }

    public double[][] searchIntervals() {
        int a = numbers[0];
        double point = searchCenter();

        if (a > 0) {
            return new double[][]{
                    {Integer.MIN_VALUE, point},
                    {point, Integer.MAX_VALUE}
            };
        }

        return new double[][]{
                {point, Integer.MAX_VALUE},
                {Integer.MIN_VALUE, point}
        };
    }
}

public class Variant19 {
    public static void main(String[] args) {
        BinaryEquation[] bes = new BinaryEquation[]{
                new BinaryEquation(1, -3, 2),
                new BinaryEquation(1, 3, 2),
                new BinaryEquation(1, -5, 6),
                new BinaryEquation(1, 5, 6),
        };

        double[] arr = bes[0].search();
        double min = arr[0], max = arr[1];
        if (min < max) {
            double t = min;
            min = max;
            max = t;
        }

        for(int i = 1; i < bes.length; ++i) {
            double[] tempA = bes[i].search();
            double cMin = arr[0], cMax = arr[1];
            if (cMin < cMax) {
                double t = cMin;
                cMin = cMax;
                cMax = t;
            }

            if (cMin < min) {
                min = cMin;
            }
            if (cMax > max) {
                max = cMax;
            }
        }

        System.out.println("Максимальный корень: " + max);
        System.out.println("Минимальный корень: " + min);
    }
}
