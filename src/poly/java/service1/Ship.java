package poly.java.service1;

public class Ship {
    private static int countShip = 0;
    private Date date;
    private final String shipName;
    private

    public Ship() {
        shipName = "Evergreen №" + ++countShip;

    }
}
