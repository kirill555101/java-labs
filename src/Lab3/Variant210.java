package Lab3;

// Создать классы, спецификации которых приведены ниже.
// Определить конструкторы и методы setТип(), getТип(), toString().
// Определить дополнительно методы в классе, создающем массив объектов.
// Задать критерий выбора данных и вывести эти данные на консоль.
// Train: Пункт назначения, Номер поезда, Время отправления, Число мест (общих, купе, плацкарт, люкс).
// Создать массив объектов. Вывести:
// a) список поездов, следующих до заданного пункта назначения;
// b) список поездов, следующих до заданного пункта назначения и отправляющихся после заданного часа;
// c) список поездов, отправляющихся до заданного пункта назначения и имеющих общие места

class Train {
    private final String destination;
    private final String number;
    private int departureTime;
    private final int generalCount;
    private final int compartmentCount;
    private final int reservedCount;
    private final int suiteCount;

    public Train(String destination, String number, int departureTime, int generalCount, int compartmentCount, int reservedCount, int suiteCount) {
        this.destination = destination;
        this.number = number;
        this.departureTime = departureTime;
        this.generalCount = generalCount;
        this.compartmentCount = compartmentCount;
        this.reservedCount = reservedCount;
        this.suiteCount = suiteCount;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return this.destination;
    }
    public int getDepartureTime() {
        return this.departureTime;
    }
    public int getGeneralCount() {
        return this.generalCount;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %d", this.number, this.destination, this.departureTime);
    }
}

public class Variant210 {
    public static void main(String[] args) {
        var trains = new Train[]{
                new Train("Moscow", "1", 11, 50, 0, 10, 0),
                new Train("London", "2", 5, 0, 50, 10, 0)
        };

        var destination = "Moscow";
        var departureTime = 10;
        var generalCount = 0;

        System.out.println("а");
        for(Train tr : trains) {
            if (tr.getDestination().equals(destination)) {
                System.out.println(tr);
            }
        }

        System.out.println("б");
        for(Train tr : trains) {
            if (tr.getDestination().equals(destination) && tr.getDepartureTime() > departureTime) {
                System.out.println(tr);
            }
        }

        System.out.println("в");
        for(Train tr : trains) {
            if (tr.getDestination().equals(destination) && tr.getGeneralCount() > generalCount) {
                System.out.println(tr);
            }
        }
    }
}
