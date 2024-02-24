package Lab1;

// Создать приложение, которое отображает в окне консоли аргументы командной строки
// метода main() в обратном порядке.

public class Variant12 {
    public static void main(String[] args) {
        System.out.print("Аргументы в обратном порядке: ");
        for (int i = args.length - 1; i >= 0; --i) {
            System.out.print(args[i] + " ");
        }
        System.out.println();
    }
}
