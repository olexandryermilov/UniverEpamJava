package weathertask.displays;

import weathertask.weatherstation.WeatherData;
import weathertask.weatherstation.WeatherObserver;

public class CurrentConditionsDisplay implements Display, WeatherObserver {
    private double currentTemperature, currentHumidity, currentPressure;
    public void update(WeatherData weatherData) {
        currentHumidity=weatherData.getHumidity();
        currentTemperature=weatherData.getTemp();
        currentPressure=weatherData.getPressure();
    }
    private CurrentConditionsDisplay(){
    }
    private static CurrentConditionsDisplay instance;
    public static CurrentConditionsDisplay getInstance(){
        if(instance==null){
            instance = new CurrentConditionsDisplay();
        }
        return instance;
    }
    public void print(){
        System.out.println(this.toString());
    }
    public WeatherData getFieldsAsWeatherData(){
        return new WeatherData(currentTemperature,currentHumidity,currentPressure);
    }

    @Override
    public String toString() {
        return "CurrentConditionsDisplay:" +
                "currentTemperature=" + currentTemperature +
                ", currentHumidity=" + currentHumidity +
                ", currentPressure=" + currentPressure;
    }
}
