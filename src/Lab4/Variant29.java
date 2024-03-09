package Lab4;

// Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов
// interface Мебель <- abstract class Шкаф <- class Книжный Шкаф.

interface Furniture {
    public default void call() {}
}

abstract class Wardrobe implements Furniture {
    @Override
    public void call() {
        System.out.println("Wardrobe");
    }
}

class Bookcase extends Wardrobe {
    @Override
    public void call() {
        System.out.println("Bookcase");
    }
}

public class Variant29 {
    public static void main(String[] args) {
        new Bookcase().call();
    }
}
