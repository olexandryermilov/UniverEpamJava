package weathertask.weatherstation;

public interface Subject {
    public void registerObserver(WeatherObserver observer);
    public void removeObserver(WeatherObserver observer);
    public void notifyObservers();
}
