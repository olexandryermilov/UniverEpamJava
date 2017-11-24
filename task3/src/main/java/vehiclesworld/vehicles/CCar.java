package vehiclesworld.vehicles;

public class CCar extends CVehicle implements Moveable{
    public CCar(int cost, int speed, int year) {
        super(cost, speed, year);
    }

    @Override
    public int move() {
        return getSpeed();
    }
}
