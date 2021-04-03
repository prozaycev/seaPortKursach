package poly.java.service1.ship;

public class Cargo {
    private int countCargo = 0;
    private final CargoType cargoType;
    public static final int MAX_COUNT_CARGO_IN_SHIP = 1000;

    public Cargo(int countCargo, CargoType cargoType) {
        if (countCargo <= 0) {
            throw new IllegalArgumentException("Count of cargo should be positive");
        }
        this.countCargo = countCargo;
        this.cargoType = cargoType;
    }

    public int getCountCargo() {
        return countCargo;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public enum CargoType {
        BOX {
            @Override
            public String toString() { return "Box"; }
            },
        LOOSE {
            @Override
            public String toString() {
                return "Loos";
            }
            }, // сыпучее
        LIQUID {
            @Override
            public String toString() {
                return "Liquid";
            }
        }, // текучее
    }

    @Override
    public String toString() {
        return cargoType + "[" + countCargo + "]";
    }
}
