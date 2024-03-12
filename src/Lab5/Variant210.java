package Lab5;

// Выполнить задания из варианта 2 лабораторной работы 3, реализуя собственные обработчики исключений и исключения ввода/вывода.

import java.util.Objects;

class TrainException extends Exception {
    public TrainException() { super(); }
    public TrainException(String message) { super(message); }
    public TrainException(String message, Throwable cause) { super(message, cause); }
    public TrainException(Throwable cause) { super(cause); }
}

class Train {
    private final String destination;
    private final String number;
    private int departureTime;
    private final int generalCount;
    private final int compartmentCount;
    private final int reservedCount;
    private final int suiteCount;

    public Train(String destination, String number, int departureTime, int generalCount, int compartmentCount, int reservedCount, int suiteCount) throws TrainException {
        if (Objects.equals(destination, "") || Objects.equals(number, "") ||
                departureTime <= 0 || generalCount <= 0 || compartmentCount <= 0 || reservedCount <= 0 || suiteCount <= 0) {
            throw new TrainException("some params are not present");
        }

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
        try {
            var trains = new Train[]{
                    new Train("Moscow", "1", 11, 50, 1, 10, 1),
                    new Train("London", "2", 5, 1, 50, 10, 1)
            };

            var destination = "Moscow";
            var departureTime = 10;
            var generalCount = 0;

            System.out.println("а");
            for (Train tr : trains) {
                if (tr.getDestination().equals(destination)) {
                    System.out.println(tr);
                }
            }

            System.out.println("б");
            for (Train tr : trains) {
                if (tr.getDestination().equals(destination) && tr.getDepartureTime() > departureTime) {
                    System.out.println(tr);
                }
            }

            System.out.println("в");
            for (Train tr : trains) {
                if (tr.getDestination().equals(destination) && tr.getGeneralCount() > generalCount) {
                    System.out.println(tr);
                }
            }
        } catch (TrainException e) {
            System.out.println(e.getMessage());
        }
    }
}
