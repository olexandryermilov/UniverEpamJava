package weathertask.weatherstation;

import java.util.ArrayList;

public class WeatherData{
    private double temp;
    private double humidity;
    private double pressure;
    public WeatherData(double temp, double humidity, double pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
    }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherData that = (WeatherData) o;

        if (Double.compare(that.temp, temp) != 0) return false;
        if (Double.compare(that.humidity, humidity) != 0) return false;
        return Double.compare(that.pressure, pressure) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp1;
        temp1 = Double.doubleToLongBits(temp);
        result = (int) (temp1 ^ (temp1 >>> 32));
        temp1 = Double.doubleToLongBits(humidity);
        result = 31 * result + (int) (temp1 ^ (temp1 >>> 32));
        temp1 = Double.doubleToLongBits(pressure);
        result = 31 * result + (int) (temp1 ^ (temp1 >>> 32));
        return result;
    }
}
