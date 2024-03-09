package Lab3;

import java.util.Objects;

// Построить модель программной системы.
// Система Железнодорожная касса. Пассажир делает Заявку на станцию назначения, время и дату поездки.
// Система регистрирует Заявку и осуществляет поиск подходящего Поезда.
// Пассажир делает выбор Поезда и получает Счет на оплату.
// Администратор вводит номера Поездов, промежуточные и конечные станции, цены

class Request {
    private String destination, date;

    public Request(String dest, String d) {
        this.destination = dest;
        this.date = d;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getDate() {
        return this.date;
    }
}

class OfficeTrain {
    private String number, destination, date;
    private int price;

    public OfficeTrain(String n, String dest, String d, int p) {
        this.number = n;
        this.destination = dest;
        this.date = d;
        this.price = p;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getDate() {
        return this.date;
    }

    public int getPrice() {
        return this.price;
    }
}

class BoxOffice {
    private OfficeTrain[] trains = {};
    private Request[] requests = {};

    public void addTrain(OfficeTrain tr) {
        var t = new OfficeTrain[this.trains.length + 1];

        System.arraycopy(this.trains, 0, t, 0, trains.length);
        t[t.length - 1] = tr;

        this.trains = t;
    }

    public void addRequest(Request r) {
        var t = new Request[this.requests.length + 1];

        System.arraycopy(this.requests, 0, t, 0, requests.length);
        t[t.length - 1] = r;

        this.requests = t;
    }

    public OfficeTrain[] findTrains(Request r) {
        OfficeTrain[] res = {};

        for (var t:trains) {
            if (!Objects.equals(t.getDestination(), r.getDestination()) ) {
                continue;
            }
            if (!Objects.equals(t.getDate(), r.getDate())) {
                continue;
            }

            var temp = new OfficeTrain[res.length + 1];

            System.arraycopy(res, 0, temp, 0, res.length);
            temp[temp.length - 1] = t;

            res = temp;
        }

        return res;
    }
}

public class Variant410 {
    public static void main(String[] args) {
        var office = new BoxOffice();
        var train = new OfficeTrain("abc", "Moscow", "01.01.2024", 500);
        var request = new Request("Moscow", "01.01.2024");

        office.addTrain(train);
        office.addRequest(request);
    }
}
