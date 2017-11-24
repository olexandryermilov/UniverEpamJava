package weathertask.displays;

import weathertask.WeatherObserver;

public class CurrentConditionsDisplay implements Display, WeatherObserver {
    private double currentTemperature, currentHumidity, currentPressure;
    public void update(double temperature,double humidity, double pressure) {
        currentHumidity=humidity;
        currentTemperature=temperature;
        currentPressure=pressure;
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

    @Override
    public String toString() {
        return "CurrentConditionsDisplay:" +
                "currentTemperature=" + currentTemperature +
                ", currentHumidity=" + currentHumidity +
                ", currentPressure=" + currentPressure;
    }
}
