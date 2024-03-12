package Lab6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

// На прямой гоночной трассе стоит N автомобилей, для каждого из которых известны начальное положение и скорость. Определить, сколько произойдет обгонов.

class Auto {
    private String name;
    private int currentPosition, speed, beMoreFirst;

    public Auto(String name) {
        this.name = name;
        this.currentPosition = new Random().nextInt(11);
        this.speed = new Random().nextInt(7) + 1;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getBeMoreFirst() {
        return this.beMoreFirst;
    }

    public void setBeMoreFirst(int beMoreFirst) {
        this.beMoreFirst = beMoreFirst;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}

class AutoComparator implements Comparator<Auto> {
    @Override
    public int compare(Auto o1, Auto o2) {
        return Integer.compare(o1.getCurrentPosition(), o2.getCurrentPosition());
    }
}

public class Variant210 {
    public static void main(String[] args) {
        ArrayList<Auto> autos = new ArrayList<Auto>();
        for (int i = 0; i < 4; i++) {
            autos.add(new Auto("Автомобиль: " + i));
        }
        autos.sort(new AutoComparator());

        // Запишем сколько машин опережает эта машина на старте
        int i = 0;
        for (Auto auto : autos) {
            auto.setBeMoreFirst(i++);
        }

        // Запускаем гонку
        boolean isEndOfRace = false;
        while (!isEndOfRace) {
            isEndOfRace = true;

            for (Auto auto : autos) {
                if (auto.getCurrentPosition() + auto.getSpeed() >= 100) {
                    auto.setCurrentPosition(100);
                    continue;
                }

                auto.setCurrentPosition(auto.getCurrentPosition() + auto.getSpeed());
                isEndOfRace = false;
            }

            autos.sort(new AutoComparator());
        }

        // Снова посчитаем какая машина на каком месте
        i = 0;
        int count = 0;
        for (Auto auto : autos) {
            if (i > auto.getBeMoreFirst()) {
                count = count + (i - auto.getBeMoreFirst());
            }
            i++;
        }
        System.out.println("Количество обгонов: " + count);
    }
}
