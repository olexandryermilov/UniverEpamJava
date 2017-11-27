package weathertask.displays;

import weathertask.weatherstation.WeatherData;
import weathertask.weatherstation.WeatherObserver;

public class StatisticsDisplay implements WeatherObserver {
    private double sumTemperature, sumHumidity,sumPressure;
    private int count;
    public void update(WeatherData weatherData) {
        sumHumidity+=weatherData.getHumidity();
        sumTemperature+=weatherData.getTemp();
        sumPressure+=weatherData.getPressure();
        count++;
    }
    private StatisticsDisplay(){
        sumHumidity=0;
        sumTemperature=0;
        sumPressure=0;
        count=0;
    }
    private static StatisticsDisplay instance;
    public static StatisticsDisplay getInstance(){
        if(instance==null){
            instance = new StatisticsDisplay();
        }
        return instance;
    }
    public void print(){
        System.out.println(this.toString());
    }
    public WeatherData getFieldsAsWeatherData(){
        return new WeatherData(sumTemperature,sumHumidity,sumPressure);
    }
    @Override
    public String toString() {
        return "StatisticsDisplay:" +
                "averageTemperature=" + sumTemperature/count +
                ", averageHumidity=" + sumHumidity/count +
                ", averagePressure=" + sumPressure/count +
                ", count=" + count ;
    }
}
