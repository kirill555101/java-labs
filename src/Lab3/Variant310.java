package Lab3;

import java.util.Objects;

// Создать приложение, удовлетворяющее требованиям, приведенным в задании.
// Аргументировать принадлежность классу каждого создаваемого метода и
// корректно переопределить для каждого класса методы equals(), hashCode(), toString().
// Создать объект класса Год, используя классы Месяц, День.
// Методы: задать дату, вывести на консоль день недели по заданной дате,
// рассчитать количество дней, месяцев в заданном временном промежутке.

class Day {
    private int number;

    public Day(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Day)) return false;
        return Objects.equals(((Day) o).number, number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(this.number);
    }
}

class Month {
    private int number;

    public Month(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Month)) return false;
        return Objects.equals(((Month) o).number, number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(this.number);
    }
}

class Year {
    private Day day;
    private Month month;
    private int number;

    public Year(Day d, Month m, int number) {
        this.day = d;
        this.month = m;
        this.number = number;
    }

    public void printWeek() {
        var week = (this.month.getNumber() - 1) * 4 + this.day.getNumber() / 2 + 1;
        System.out.println("Неделя: " + week);
    }

    public void printDifference(Year y) {
        var days = Math.abs(this.day.getNumber() - y.day.getNumber());
        var months = Math.abs(this.month.getNumber() - y.month.getNumber());

        System.out.println("Количество дней: " + days + months * 30);
        System.out.println("Количество месяцев: " + months);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Year)) return false;
        return Objects.equals(((Year) o).number, number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.format("%s.%s.%d", this.day, this.month, this.number);
    }
}

public class Variant310 {
    public static void main(String[] args) {
        Year year = new Year(new Day(1), new Month(2), 2024);
        year.printWeek();
    }
}
