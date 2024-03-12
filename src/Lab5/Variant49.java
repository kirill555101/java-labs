package Lab5;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

// При выполнении следующих заданий для вывода результатов создавать новую директорию и файл средствами класса File.
// Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.

public class Variant49 {
    public static void main(String[] args) {
        var list = new ArrayList<ArrayList<String>>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Lab5/input_49.txt"))) {
            for (String line; (line = br.readLine()) != null; ) {
                list.add(new ArrayList<>(Arrays.asList(line.split(" "))));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try (var fw = new FileWriter("src/Lab5/output_49.txt")) {
            for (ArrayList<String> line : list) {
                var temp = line.getFirst();
                line.set(0, line.getLast());
                line.set(line.size() - 1, temp);

                for (String s : line) {
                    fw.write(s + " ");
                }
                fw.write("\r\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
