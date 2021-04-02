package poly.java.service1.ship;

import poly.java.service1.Date;
import java.util.Objects;

public class Ship {
    private static int countShip = 0;
    private Date date;
    private final String shipName;
    private Cargo cargo;

    public Ship(Date date, Cargo cargo) {
        shipName = "Evergreen №" + ++countShip;
        this.date = date;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "\nShip{" +
                "Ship name:" + shipName +
                ", arrival: " + date +
                ", cargo info:" + cargo +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return Objects.equals(shipName, ((Ship)o).shipName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, shipName, cargo);
    }
}
