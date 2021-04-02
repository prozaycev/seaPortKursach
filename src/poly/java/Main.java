package poly.java;

import poly.java.service1.Timetable;
import poly.java.service1.ship.*;

public class Main {
    private static final int COUNT_SHIP = 43;


    public static void main(String[] args) {
        System.out.println("Start program");
        Timetable timetable = new Timetable(COUNT_SHIP);
        timetable.makeTimetableJson("outputJson");
    }
}
