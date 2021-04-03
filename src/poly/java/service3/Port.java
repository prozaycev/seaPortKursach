package poly.java.service3;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import poly.java.service1.Date;
import poly.java.service1.ship.*;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Port {

    private static CopyOnWriteArrayList<Ship> boxList = new CopyOnWriteArrayList<>();
    private static CopyOnWriteArrayList<Ship> looseList = new CopyOnWriteArrayList<>();
    private static CopyOnWriteArrayList<Ship> liquidList = new CopyOnWriteArrayList<>();


    private static Ship[] parsJsonTimeTable() {
        final String jsonPath = System.getProperty("user.dir") + "/outputJson.json";
        Ship[] ships = {};
        try {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader(jsonPath));
            Type type = new TypeToken<Ship[]>() {
            }.getType();
            ships = gson.fromJson(br, type);
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        return ships;
    }

    public static void randomizeShipsArrival() {
        Ship[] ships = parsJsonTimeTable();
        if (ships.length == 0) {
            System.out.println("Empty read json in service3");
        }

        for (Ship ship : ships) {
            randomizeShipArrival(ship);
        }
        boxList.sort(Comparator.comparing(Ship::getDate));
        looseList.sort(Comparator.comparing(Ship::getDate));
        liquidList.sort(Comparator.comparing(Ship::getDate));
    }

    private static void randomizeShipArrival(Ship ship) {
        try {
            int deltaTime = ThreadLocalRandom.current().nextInt(-7 * 24 * 60, 7 * 24 * 60);
            ship.setDate(new Date(ship.getDate().getMinuteFromFirstDayInMonthToArrival() + deltaTime));
            switch (ship.getCargo().getCargoType()) {
                case BOX:
                    boxList.add(ship);
                case LOOSE:
                    looseList.add(ship);
                case LIQUID:
                    liquidList.add(ship);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Ship arriving is out of bounds simulating period");
        }
    }
}
