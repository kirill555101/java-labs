package Lab9;

import java.util.Arrays;
import java.util.Collection;

// Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.
// Задана коллекция:
// (Класс Student: имя и рейтинг)
// Collection<Student> students = Arrays.asList(
//         new Student("Ivan", 40),
//         new Student("Petr", 60),
//         new Student("Olga", 70)
// );
// Вернуть список студентов имя которых начинается на P и рейтинг находится в интервале 40-60.

class Student {
    private final String name;
    private final int rating;

    public Student(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return this.name;
    }

    public int getRating() {
        return this.rating;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class Variant110 {
    public static void main(String[] args) {
        Collection<Student> students = Arrays.asList(
             new Student("Ivan", 40),
             new Student("Petr", 60),
             new Student("Olga", 70)
        );

        var newCollection = students.stream().filter(x-> x.getName().startsWith("P") && x.getRating() > 40 && x.getRating() < 60).toArray();
        for (var student : newCollection) {
            System.out.println(student);
        }
    }
}
