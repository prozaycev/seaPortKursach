package poly.java.service2;

import poly.java.service1.Timetable;
import poly.java.service3.Port;

public class Storage {
    private Timetable trueTimetable;

    public Storage(int countShip) {
        String jsonFileName = "outputJson.json";
        trueTimetable = new Timetable(countShip);
        trueTimetable.makeTimetableJson(jsonFileName);
        Port.simulatePort(jsonFileName, 2, 2,2);
    }

}
