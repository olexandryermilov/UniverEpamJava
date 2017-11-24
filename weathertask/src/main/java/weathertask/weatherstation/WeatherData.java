package weathertask.weatherstation;

import java.util.ArrayList;

public class WeatherData {
    private double temp;
    private double humidity;
    private double pressure;
    private ArrayList<Object> main;

    public WeatherData(double temp, double humidity, double pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    private ArrayList<Object> base;

    public WeatherData() {
    }

    public double getTemp() {
        return temp;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "temp=" + temp +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                '}';
    }

    public ArrayList<Object> getMain() {
        return main;
    }

    public ArrayList<Object> getBase() {
        return base;
    }
}
