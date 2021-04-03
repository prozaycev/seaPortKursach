package poly.java.service1;

import com.google.gson.*;
import poly.java.service1.ship.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Timetable {
    private Ship[] ships;

    public Timetable(int countShip) {
        final int timeStep = (int) (Date.MINUTES_IN_MONTH / countShip);
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

    public void makeTimetableJson(String fileName) {
        try (Writer writer = new FileWriter(fileName)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(ships, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Ship[] getShips() {
        return ships;
    }

    @Override
    public String toString() {
        return "Timetable ships:\n" + Arrays.toString(ships);
    }
}
