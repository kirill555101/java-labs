package Lab8;

// Реализовать многопоточное приложение “Магазин”. Вся цепочка: производитель-магазин-покупатель.
// Пока производитель не поставит на склад продукт, покупатель не может его забрать.
// Реализовать приход товара от производителя в магазин случайным числом.
// В том случае, если товара в магазине не хватает – вывести сообщение.

public class Variant13 {
    static boolean product_send;
    static boolean product_got;

    static class CreatorThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; ++i) {
                double random = 0;
                try {
                    sleep(1000);
                    random = Math.random();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                if (random > 0.5) {
                    System.out.println("Товар отправлен");
                    product_send = true;
                }
            }
        }
    }

    static class ShopThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; ++i) {
                try {
                    sleep(1000);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                if (product_send) {
                    System.out.println("Товар доставлен, можно забрать");
                    product_got = true;
                } else {
                    System.out.println("Товар ожидается");
                }
            }
        }
    }

    static class UserThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; ++i) {
                try {
                    sleep(1000);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                if (product_got) {
                    System.out.println("Товар забрали");
                    product_got = false;
                    product_send = false;
                }
            }
        }
    }

    public static void main(String []args){
        new CreatorThread().start();
        new ShopThread().start();
        new UserThread().start();
    }
}

