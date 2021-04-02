package poly.java.service1;

import poly.java.service1.ship.*;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Timetable {
    private Ship[] ships;

    public Timetable(int countShip) {
        final int timeStep = (int)(Date.SECOND_IN_MONTH/countShip);
        this.ships = new Ship[countShip];
        for (int i = 0; i < countShip; ++i) {
            try {
                Date date = new Date(timeStep * i);
                Cargo.CargoType cargoType = Cargo.CargoType.values()[ThreadLocalRandom.current().nextInt(0, 3)];
                Cargo cargo = new Cargo(ThreadLocalRandom.current().nextInt(0, Cargo.MAX_COUNT_CARGO_IN_SHIP), cargoType);
                this.ships[i] = new Ship(date, cargo);
            } catch (IllegalArgumentException e) {
                System.err.println("Ship is not create: " + e);
            }
        }
    }

    @Override
    public String toString() {
        return "Timetable ships:\n" + Arrays.toString(ships);
    }
}
