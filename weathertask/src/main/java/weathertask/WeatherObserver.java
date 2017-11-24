package weathertask;

public interface WeatherObserver {
    public void update(double newTemperature,double newHumidity, double newPressure);
}
