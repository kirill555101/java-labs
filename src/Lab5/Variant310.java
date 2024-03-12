package Lab5;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;

// В следующих заданиях требуется ввести последовательность строк из текстового потока и выполнить указанные действия.
// При этом могут рассматриваться два варианта:
// • каждая строка состоит из одного слова;
// • каждая строка состоит из нескольких слов.
// Имена входного и выходного файлов, а также абсолютный путь к ним могут быть введены как параметры командной строки или храниться в файле.
// Входной файл хранит квадратную матрицу по принципу: строка представляет собой число. Определить размерность.
// Построить 2-мерный массив, содержащий матрицу. Вывести исходную матрицу и результат ее поворота на 90 градусов по часовой стрелке.

public class Variant310 {
    public static void main(String[] args) {
        var list = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Lab5/input_310.txt"))) {
            for (String line; (line = br.readLine()) != null; ) {
                list.add(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        var dimension = (int)Math.sqrt(list.size());
        var newList = new ArrayList<ArrayList<String>>();
        var clockWisedList = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < dimension; ++i) {
            var temp = new ArrayList<String>();
            for (int j = 0; j < dimension; ++j) {
                temp.add(list.get(i * dimension + j));
            }

            newList.add(temp);
            clockWisedList.add((ArrayList<String>) temp.clone());
        }

        for (int i = 0; i < clockWisedList.getFirst().size(); ++i) {
            for (int j = 0; j < clockWisedList.size(); ++j) {
                clockWisedList.get(j).set(clockWisedList.getFirst().size() - 1 - i, newList.get(i).get(j));
            }
        }

        try (var fw = new FileWriter("src/Lab5/output_310.txt")) {
            for (int i = 0; i < newList.size(); ++i) {
                for (int j = 0; j < newList.getFirst().size(); ++j) {
                    fw.write(newList.get(i).get(j) + " ");
                }

                fw.write("\r\n");
            }
            fw.write("\r\n");

            for (int i = 0; i < clockWisedList.size(); ++i) {
                for (int j = 0; j < clockWisedList.getFirst().size(); ++j) {
                    fw.write(clockWisedList.get(i).get(j) + " ");
                }

                fw.write("\r\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
