package Lab6;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// Задан файл с текстом на английском языке. Выделить все различные слова.
// Слова, отличающиеся только регистром букв, считать одинаковыми. Использовать класс HashSet.

public class Variant19 {
    public static void main(String[] args) {
        var list = new ArrayList<ArrayList<String>>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Lab6/input_19.txt"))) {
            for (String line; (line = br.readLine()) != null; ) {
                list.add(new ArrayList<>(Arrays.asList(line.split(" "))));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        var hash = new HashSet<String>();
        for (ArrayList<String> line : list) {
            for (String word : line) {
                hash.add(word.toLowerCase());
            }
        }

        System.out.print("Уникальные слова: ");
        for (String word : hash) {
            System.out.print(word + " ");
        }
    }
}
