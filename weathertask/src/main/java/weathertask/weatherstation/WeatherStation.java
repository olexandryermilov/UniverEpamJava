package weathertask.weatherstation;

import weathertask.Subject;
import weathertask.WeatherObserver;
import weathertask.apiwork.APIAdapter;
import weathertask.displays.CurrentConditionsDisplay;
import weathertask.displays.ForecastDisplay;
import weathertask.displays.StatisticsDisplay;

import java.util.ArrayList;

public class WeatherStation implements Subject {
    ///double temperature,humidity,pressure;
    CurrentConditionsDisplay currentConditionsDisplay;
    StatisticsDisplay statisticsDisplay;
    ForecastDisplay forecastDisplay;
    ArrayList<WeatherObserver>observers;
    private WeatherData currentWeather;
    public WeatherStation() {
        currentConditionsDisplay = CurrentConditionsDisplay.getInstance();
        statisticsDisplay=StatisticsDisplay.getInstance();
        forecastDisplay=ForecastDisplay.getInstance();
        currentWeather = new WeatherData();
    }

    public double getTemperature() {
        return currentWeather.getTemp();
        //return temperature;

    }

    public double getHumidity() {
        return currentWeather.getHumidity();
        //return humidity;
    }

    public double getPressure() {
        return currentWeather.getPressure();
        //return pressure;
    }
    public void registerObserver(WeatherObserver observer){
        observers.add(observer);
    }
    public void removeObserver(WeatherObserver observer){
        observers.remove(observer);
    }
    public void notifyObservers(double newTemperature,double newHumidity, double newPressure){
        for(WeatherObserver observer : observers){
            observer.update(newTemperature, newHumidity, newPressure);
        }
    }
    public void measurementsChanged(){
        try {
            currentWeather = new APIAdapter().getWeatherData();
        } catch (Exception e) {
            System.out.println(e.getCause());
            return;
        }
        double temp = getTemperature();
        double humidity = getHumidity();
        double pressure = getPressure();
        currentConditionsDisplay.update(temp,humidity,pressure);
        statisticsDisplay.update(temp,humidity,pressure);
        forecastDisplay.update(temp,humidity,pressure);
    }

    @Override
    public String toString() {
        return Double.toString(getTemperature())+" "+Double.toString(getHumidity())+" "+Double.toString(getPressure());
    }
}
