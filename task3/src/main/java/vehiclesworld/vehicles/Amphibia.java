package vehiclesworld.vehicles;

public class Amphibia extends CVehicle implements Swimable,Moveable {
    public Amphibia(int cost, int speed, int year) {
        super(cost, speed, year);
    }

    @Override
    public int move() {
        return getSpeed();
    }

    @Override
    public int swim() {
        return getSpeed();
    }
}
