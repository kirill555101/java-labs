package Lab8;

// Реализовать многопоточное приложение “Робот”. Надо написать робота, который умеет ходить.
// За движение каждой его ноги отвечает отдельный поток. Шаг выражается в выводе в консоль LEFT или RIGHT.

class LeftThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; ++i) {
            try {
                sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("LEFT");
        }
    }
}

class RightThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; ++i) {
            try {
                sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("RIGHT");
        }
    }
}

public class Variant12 {
    public static void main(String []args){
        new LeftThread().start();
        new RightThread().start();
    }
}

