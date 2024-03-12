package Lab5;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

// При выполнении следующих заданий для вывода результатов создавать новую директорию и файл средствами класса File.
// Ввести из текстового файла, связанного с входным потоком, последовательность строк. Выбрать и сохранить m последних слов в каждой из последних n строк

public class Variant410 {
    public static void main(String[] args) {
        var list = new ArrayList<ArrayList<String>>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Lab5/input_410.txt"))) {
            for (String line; (line = br.readLine()) != null; ) {
                list.add(new ArrayList<>(Arrays.asList(line.split(" "))));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int m = 3, n = 2;
        try (var fw = new FileWriter("src/Lab5/output_410.txt")) {
            for (int i = list.size() - n; i < list.size(); ++i) {
                var line = list.get(i);
                for (int j = line.size() - m; j < line.size(); ++j) {
                    fw.write(list.get(i).get(j) + " ");
                }

                fw.write("\r\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
