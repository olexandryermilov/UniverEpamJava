package weathertask.displays;

import weathertask.WeatherObserver;

public class StatisticsDisplay implements WeatherObserver {
    private double sumTemperature, sumHumidity,sumPressure;
    private int count;
    public void update(double newTemperature,double newHumidity, double newPressure) {
        sumTemperature+=newTemperature;
        sumHumidity+=newHumidity;
        sumPressure+=newPressure;
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

    @Override
    public String toString() {
        return "StatisticsDisplay:" +
                "sumTemperature=" + sumTemperature +
                ", sumHumidity=" + sumHumidity +
                ", sumPressure=" + sumPressure +
                ", count=" + count ;
    }
}
