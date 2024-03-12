package Lab5;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

// В следующих заданиях требуется ввести последовательность строк из текстового потока и выполнить указанные действия.
// При этом могут рассматриваться два варианта:
// • каждая строка состоит из одного слова;
// • каждая строка состоит из нескольких слов.
// Имена входного и выходного файлов, а также абсолютный путь к ним могут быть введены как параметры командной строки или храниться в файле.
// Входной файл содержит совокупность строк. Строка файла содержит строку квадратной матрицы.
// Ввести матрицу в двумерный массив (размер матрицы найти). Вывести исходную матрицу и результат ее транспонирования.

public class Variant39 {
    public static void main(String[] args) {
        var list = new ArrayList<ArrayList<String>>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Lab5/input_39.txt"))) {
            for (String line; (line = br.readLine()) != null; ) {
                list.add(new ArrayList<>(Arrays.asList(line.split(" "))));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try (var fw = new FileWriter("src/Lab5/output_39.txt")) {
            for (int i = 0; i < list.size(); ++i) {
                for (int j = 0; j <list.getFirst().size(); ++j) {
                    fw.write(list.get(i).get(j) + " ");
                }

                fw.write("\r\n");
            }
            fw.write("\r\n");

            for (int i = 0; i < list.getFirst().size(); ++i) {
                for (int j = 0; j < list.size(); ++j) {
                    fw.write(list.get(j).get(i) + " ");
                }

                fw.write("\r\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
