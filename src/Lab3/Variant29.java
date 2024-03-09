package Lab3;

// Создать классы, спецификации которых приведены ниже.
// Определить конструкторы и методы setТип(), getТип(), toString().
// Определить дополнительно методы в классе, создающем массив объектов.
// Задать критерий выбора данных и вывести эти данные на консоль.
// Product: id, Наименование, UPC, Производитель, Цена, Срок хранения, Количество.
// Создать массив объектов. Вывести:
// a) список товаров для заданного наименования;
// b) список товаров для заданного наименования, цена которых не превосходит заданную;
// c) список товаров, срок хранения которых больше заданного.

import java.util.Objects;

class Product {
    private final int id;
    private int price;
    private int count;
    private final int days;
    private final String name;
    private final String upc;
    private final String creator;

    public Product(int id, int price, int count, int days, String name, String upc, String creator) {
        this.id = id;
        this.price = price;
        this.count = count;
        this.days = days;
        this.name = name;
        this.upc = upc;
        this.creator = creator;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return this.name;
    }
    public int getPrice() {
        return this.price;
    }
    public int getCount() {
        return this.count;
    }
    public int getDays() {
        return this.days;
    }

    @Override
    public String toString() {
        return String.format("%d - %s - %s - %s - %d", this.id, this.name, this.upc, this.creator, this.days);
    }
}

public class Variant29 {
    public static void main(String[] args) {
        var products = new Product[]{
                new Product(1, 2, 3, 4, "n1", "u2", "c3"),
                new Product(2, 2, 3, 10, "n1", "u3", "c3")
        };

        var name = "n1";
        var price = 5;
        var days = 7;

        System.out.println("а");
        for (Product pr : products) {
            if (pr.getName().equals(name)) {
                System.out.println(pr);
            }
        }

        System.out.println("б");
        for (Product pr : products) {
            if (pr.getName().equals(name) && pr.getPrice() <= price) {
                System.out.println(pr);
            }
        }

        System.out.println("в");
        for (Product pr : products) {
            if (pr.getDays() > days) {
                System.out.println(pr);
            }
        }
    }
}
