package Lab5;

// Выполнить задания из варианта 2 лабораторной работы 3, реализуя собственные обработчики исключений и исключения ввода/вывода.

import java.util.Objects;

class ProductException extends Exception {
    public ProductException() { super(); }
    public ProductException(String message) { super(message); }
    public ProductException(String message, Throwable cause) { super(message, cause); }
    public ProductException(Throwable cause) { super(cause); }
}

class Product {
    private final int id;
    private int price;
    private int count;
    private final int days;
    private final String name;
    private final String upc;
    private final String creator;

    public Product(int id, int price, int count, int days, String name, String upc, String creator) throws ProductException {
        if (id <= 0 || price <= 0 || count <= 0 || days <= 0 || Objects.equals(name, "") ||
                Objects.equals(upc, "") || Objects.equals(creator, "")) {
            throw new ProductException("some params are not present");
        }

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
        try {
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
        } catch (ProductException e) {
            System.out.println(e.getMessage());
        }
    }
}
