package Lab4;

// Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов
// interface Фильм <- class Отечественный Фильм <- class Комедия.

interface Movie {
    public default void call() {}
}

abstract class DomesticFilm implements Movie {
    @Override
    public void call() {
        System.out.println("DomesticFilm");
    }
}

class Comedy extends DomesticFilm {
    @Override
    public void call() {
        System.out.println("Comedy");
    }
}

public class Variant210 {
    public static void main(String[] args) {
        new Comedy().call();
    }
}
