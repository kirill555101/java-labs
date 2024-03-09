package Lab3;

import java.util.Objects;

// Построить модель программной системы.
// Система Интернет-магазин. Администратор добавляет информацию о Товаре.
// Клиент делает и оплачивает Заказ на Товары.
// Администратор регистрирует Продажу и может занести неплательщиков в «черный список».

class ShopProduct {
    private String name;

    public ShopProduct(String name) {
        this.name = name;
    }
}

class User {
    private String name;
    private boolean banned = false;

    public User(String name) {
        this.name = name;
        this.banned = false;
    }

    public void ban(boolean banned) {
        this.banned = banned;
    }

    public String getName() {
        return this.name;
    }
}

class Order {
    private int id;
    private ShopProduct[] list;
    private User user;
    private boolean payed;

    public Order(int id, ShopProduct[] list, User user) {
        this.id = id;
        this.list = list;
        this.user = user;
        this.payed = false;
    }

    public int getID() {
        return id;
    }

    public void pay() {
        this.payed = true;
    }
}

class Shop {
    private ShopProduct[] products = {};
    private Order[] orders = {};
    private User[] users = {};

    public void addProduct(ShopProduct p) {
        var t = new ShopProduct[this.users.length + 1];

        System.arraycopy(this.products, 0, t, 0, products.length);
        t[t.length - 1] = p;

        this.products = t;
    }

    public void addOrder(Order o) {
        var t = new Order[this.users.length + 1];

        System.arraycopy(this.orders, 0, t, 0, orders.length);
        t[t.length - 1] = o;

        this.orders = t;
    }

    public void addUser(User u) {
        var t = new User[this.users.length + 1];

        System.arraycopy(this.users, 0, t, 0, users.length);
        t[t.length - 1] = u;

        this.users = t;
    }

    public User findUser(String name) {
        for (var u : users) {
            if (Objects.equals(u.getName(), name)) {
                return u;
            }
        }

        return null;
    }

    public Order findOrder(int id) {
        for (var o : orders) {
            if (o.getID() == id) {
                return o;
            }
        }

        return null;
    }
}

public class Variant49 {
    public static void main(String[] args) {
        var shop = new Shop();
        var product = new ShopProduct("product");
        var user = new User("user");

        shop.addProduct(product);
        shop.addUser(user);
        shop.addOrder(new Order(1, new ShopProduct[]{product}, user));
    }
}