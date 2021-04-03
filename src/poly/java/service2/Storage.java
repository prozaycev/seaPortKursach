package poly.java.service2;

import poly.java.service1.Timetable;
import poly.java.service3.Port;

public class Storage {
    private Timetable trueTimetable;
    private Timetable realTimetable;

    public Storage(int countShip) {
        trueTimetable = new Timetable(countShip);
        trueTimetable.makeTimetableJson("outputJson");
        Port.randomizeShipsArrival();
    }

}
