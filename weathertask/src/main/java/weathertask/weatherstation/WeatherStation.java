package weathertask.weatherstation;

import javafx.beans.binding.ObjectExpression;
import weathertask.apiwork.APIAdapter;
import weathertask.displays.CurrentConditionsDisplay;
import weathertask.displays.ForecastDisplay;
import weathertask.displays.StatisticsDisplay;

import java.util.ArrayList;
import java.util.Observer;

public class WeatherStation implements Subject {
    ///double temperature,humidity,pressure;
    CurrentConditionsDisplay currentConditionsDisplay;
    StatisticsDisplay statisticsDisplay;
    ForecastDisplay forecastDisplay;
    ArrayList<WeatherObserver>observers;
    APIAdapter apiAdapter;
    private WeatherData currentWeather;
    public WeatherStation() {
        currentConditionsDisplay = CurrentConditionsDisplay.getInstance();
        statisticsDisplay=StatisticsDisplay.getInstance();
        forecastDisplay=ForecastDisplay.getInstance();
        currentWeather = new WeatherData();
        apiAdapter = new APIAdapter();
        observers = new ArrayList<>();
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
    public boolean measurementsChanged(){
        try {
            WeatherData newWeather = apiAdapter.getWeatherData();
            if(!newWeather.equals(currentWeather))currentWeather=newWeather;
            else return false;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return false;
        }
        double temp = getTemperature();
        double humidity = getHumidity();
        double pressure = getPressure();
        for(WeatherObserver observer: observers){
            observer.update(temp,humidity,pressure);
        }
        return true;
    }

    @Override
    public String toString() {
        return Double.toString(getTemperature())+" "+Double.toString(getHumidity())+" "+Double.toString(getPressure());
    }
}
