package poly.java.service3;

import poly.java.service1.ship.Ship;

import java.util.concurrent.CopyOnWriteArrayList;

public class Crane implements Runnable {
    private final int performance;
    private CopyOnWriteArrayList<Ship> shipQueue; // I have not come up with a better name

    public Crane(int performance) {
        this.performance = performance;
    }

    public void setShipQueue(CopyOnWriteArrayList<Ship> shipQueue) {
        this.shipQueue = shipQueue;
    }

    @Override
    public void run() {

    }
}
