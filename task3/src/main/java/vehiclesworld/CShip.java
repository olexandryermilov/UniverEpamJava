package vehiclesworld;

public class CShip extends CVehicle implements Swimable{
    private int passengers;
    private String port;
    public CShip(int cost, int speed, int year, int passengers, String port) {
        super(cost, speed, year);
        this.passengers=passengers;
        this.port=port;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int swim() {
        return getSpeed();
    }
}
