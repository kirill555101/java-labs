package Lab4;

// Создать класс Park (парк) с внутренним классом,
// с помощью объектов которого можно хранить информацию об аттракционах, времени их работы и стоимости.

class Park {
    private class Attraction {
        private String name, time;
        private int price;

        public Attraction(String name, String time, int price) {
            this.name = name;
            this.time = time;
            this.price = price;
        }
    }

    private Attraction[] attractions = {};

    public void addAttraction(String name, String time, int price) {
        var t = new Attraction[this.attractions.length + 1];

        System.arraycopy(this.attractions, 0, t, 0, attractions.length);
        t[t.length - 1] = new Attraction(name, time, price);

        this.attractions = t;
    }
}

public class Variant19 {
    public static void main(String[] args) {
        var park = new Park();
        park.addAttraction("abc", "10:00-11:00", 500);
    }
}