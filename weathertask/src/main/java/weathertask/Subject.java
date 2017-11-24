package weathertask;

public interface Subject {
    public void registerObserver(WeatherObserver observer);
    public void removeObserver(WeatherObserver observer);
    public void notifyObservers(double newTemperature,double newHumidity, double newPressure);
}
