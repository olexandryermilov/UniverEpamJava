package vehiclesworld;

public class CPlane extends CVehicle implements Flyable{
    private int passengers;
    private int height;
    public CPlane(int cost, int speed, int year,int passengers,int height) {
        super(cost, speed, year);
        this.passengers=passengers;
        this.height=height;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int fly() {
        return getSpeed();
    }
}
