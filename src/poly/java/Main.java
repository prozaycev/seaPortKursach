package poly.java;

import poly.java.service2.Storage;
import poly.java.service3.Port;

public class Main {
    private static final int COUNT_SHIP = 43;

    public static void main(String[] args) {
        System.out.println("Start program");
        Storage storage = new Storage(COUNT_SHIP);
    }
}
