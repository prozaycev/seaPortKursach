package poly.java.service1.ship;

import poly.java.service1.Date;

import java.util.Objects;

public class Ship {
    private final String shipName;
    private static int countShip = 0;
    private Date date;
    private final Cargo cargo;

    public Ship(Date date, Cargo cargo) {
        shipName = "Evergreen №" + ++countShip;
        this.date = date;
        this.cargo = cargo;
    }

    public Cargo getCargo() { return cargo; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    @Override
    public String toString() {
        return "\nShip{" +
                "Ship name: " + shipName +
                ", arrival: " + date +
                ", cargo info: " + cargo +
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
        return Objects.equals(shipName, ((Ship) o).shipName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, shipName, cargo);
    }

}
