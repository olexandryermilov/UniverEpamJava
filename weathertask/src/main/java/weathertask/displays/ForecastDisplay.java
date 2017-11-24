package weathertask.displays;

import weathertask.WeatherObserver;

public class ForecastDisplay implements WeatherObserver{

    private double futureTemperature,futureHumidity,futurePressure;
    public void update(double newTemperature,double newHumidity, double newPressure) {
        futureTemperature=newTemperature+1;
        futureHumidity=newHumidity*1.01;
        futurePressure=newPressure*1.01;
    }
    private ForecastDisplay(){
    }
    private static ForecastDisplay instance;
    public static ForecastDisplay getInstance(){
        if(instance==null){
            instance = new ForecastDisplay();
        }
        return instance;
    }
    public void print(){
        System.out.println(this.toString());
    }
    @Override
    public String toString() {
        return "ForecastDisplay:" +
                "futureTemperature=" + futureTemperature +
                ", futureHumidity=" + futureHumidity +
                ", futurePressure=" + futurePressure ;
    }
}
