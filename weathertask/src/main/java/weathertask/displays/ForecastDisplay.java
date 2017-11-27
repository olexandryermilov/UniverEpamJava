package weathertask.displays;

import weathertask.weatherstation.WeatherData;
import weathertask.weatherstation.WeatherObserver;

import java.util.Date;
import java.util.Random;

public class ForecastDisplay implements WeatherObserver{

    private double futureTemperature,futureHumidity,futurePressure;
    final static Random random = new Random(new Date().getTime());
    public void update(WeatherData weatherData) {
        futureTemperature=weatherData.getTemp()+(Integer.signum(random.nextInt())*(Math.abs(random.nextInt())%5));
        futureHumidity=weatherData.getHumidity()+(Integer.signum(random.nextInt())*(Math.abs(random.nextInt())%5));
        futurePressure=weatherData.getPressure()+(Integer.signum(random.nextInt())*(Math.abs(random.nextInt())%5));
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
