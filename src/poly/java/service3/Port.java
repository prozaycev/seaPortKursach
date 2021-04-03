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

    private static final int PERFORMANCE_BOX_CRANE = 40; // containers per hour
    private static final int PERFORMANCE_LOOSE_CRANE = 50; // tons per hour
    private static final int PERFORMANCE_LIQUID_CRANE = 60; // tons per hour

    private static CopyOnWriteArrayList<Ship> boxList = new CopyOnWriteArrayList<>();
    private static CopyOnWriteArrayList<Ship> looseList = new CopyOnWriteArrayList<>();
    private static CopyOnWriteArrayList<Ship> liquidList = new CopyOnWriteArrayList<>();

    public static void simulatePort(String jsonFileName, int countBoxCrane, int countLooseCrane, int countLiquidCrane) {
        Ship[] ships = parsJsonTimeTable(jsonFileName);
        randomizeShipsArrival(ships);
        /*
        Thread[] boxCraneThread = new Thread[countBoxCrane];
        for (int i = 0; i < boxCraneThread.length; i++) {
            boxCraneThread[i] = new Thread(new Crane(PERFORMANCE_BOX_CRANE));
        }
        Thread[] looseCraneThread = new Thread[countLooseCrane];
        for (int i = 0; i < looseCraneThread.length; i++) {
            looseCraneThread[i] = new Thread();
        }
        Thread[] liquidCraneThread = new Thread[countLiquidCrane];
        for (int i = 0; i < liquidCraneThread.length; i++) {
            liquidCraneThread[i] = new Thread();
        }
       */
    }

    private static Ship[] parsJsonTimeTable(String jsonFileName) {
        final String jsonPath = System.getProperty("user.dir") + '/' + jsonFileName;
        Ship[] ships = {};
        try {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader(jsonPath));
            Type type = new TypeToken<Ship[]>(){}.getType();
            ships = gson.fromJson(br, type);
        } catch (FileNotFoundException e) {
            System.err.println("File not found"); // косяк, надо пробросить дальше
        }
        return ships;
    }

    private static void randomizeShipsArrival(Ship[] ships) {
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