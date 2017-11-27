package weathertasktest.weatherstationtest;

import jdk.nashorn.internal.runtime.ECMAException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import weathertask.apiwork.APIAdapter;
import weathertask.displays.CurrentConditionsDisplay;
import weathertask.displays.StatisticsDisplay;
import weathertask.weatherstation.WeatherData;
import weathertask.weatherstation.WeatherObserver;
import weathertask.weatherstation.WeatherStation;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherStationTest {
    private APIAdapter mockAdapter;
    private WeatherStation weatherStation;
    @Before
    public void initMockAdapter(){
        mockAdapter = mock(APIAdapter.class);
    }
    @Before
    public void initWeatherStation(){
        weatherStation = new WeatherStation();
    }
    @Test
    public void measurementsChanged_getsNewDataCorrectly_CorrectData(){
        WeatherData wd = new WeatherData(30.0,10,1000);
        try {
            when(mockAdapter.getWeatherData()).thenReturn(wd);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        weatherStation.setApiAdapter(mockAdapter);
        weatherStation.measurementsChanged();
        assertEquals(wd,weatherStation.getCurrentWeather());
    }
    @Test
    public void measurementsChanged_ReturnsTrue_CorrectData(){
        WeatherData wd = new WeatherData(30.0,10,1000);
        try {
            when(mockAdapter.getWeatherData()).thenReturn(wd);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        weatherStation.setApiAdapter(mockAdapter);
        assertTrue(weatherStation.measurementsChanged());
    }
    @Test
    public void measurementsChanged_ReturnsFalse_SameData(){
        WeatherData wd = new WeatherData(30.0,10,1000);
        try {
            when(mockAdapter.getWeatherData()).thenReturn(wd,wd);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        weatherStation.setApiAdapter(mockAdapter);
        weatherStation.measurementsChanged();
        assertTrue(!(weatherStation.measurementsChanged()));
    }
    @Test
    public void measurementsChanged_ReturnsFalse_ExceptionThrown(){
        try {
            when(mockAdapter.getWeatherData()).thenThrow(new Exception());
        } catch (Exception e) {
            //e.printStackTrace();
        }
        weatherStation.setApiAdapter(mockAdapter);
        weatherStation.measurementsChanged();
        assertTrue(!(weatherStation.measurementsChanged()));
    }
    @Test
    public void registerObserver_registers(){
        WeatherObserver wo = (weatherData) -> {};
        weatherStation.registerObserver(wo);
        assertThat(weatherStation.getObservers(),hasItem(wo));
    }

    @Test
    public void removeObserver_removes(){
        WeatherObserver wo = (weatherData) -> {};
        weatherStation.registerObserver(wo);
        weatherStation.removeObserver(wo);
        assertThat(weatherStation.getObservers(),not(hasItem(wo)));
    }

    @Test
    public void notifiesObserver_currentConditionDisplay(){
        CurrentConditionsDisplay currentConditionsDisplay = CurrentConditionsDisplay.getInstance();
        weatherStation.registerObserver(currentConditionsDisplay);
        WeatherData wd = new WeatherData(30.0,10,1000);
        try {
            when(mockAdapter.getWeatherData()).thenReturn(wd);
        }catch (Exception e){
            assertTrue(false);
        }
        weatherStation.setApiAdapter(mockAdapter);
        weatherStation.measurementsChanged();
        assertTrue(currentConditionsDisplay.getFieldsAsWeatherData().equals(wd));
    }
    @Test
    public void notifiesObserver_StatisticsDisplay(){
        StatisticsDisplay statisticsDisplay = StatisticsDisplay.getInstance();
        weatherStation.registerObserver(statisticsDisplay);
        WeatherData wd1 = new WeatherData(30.0,10,1000);
        WeatherData wd2 = new WeatherData(31.0,12,1002);
        WeatherData sumWD = new WeatherData(61,22,2002.0);
        try {
            when(mockAdapter.getWeatherData()).thenReturn(wd1,wd2);
        }catch (Exception e){
            assertTrue(false);
        }
        weatherStation.setApiAdapter(mockAdapter);
        weatherStation.measurementsChanged();
        weatherStation.measurementsChanged();
        System.out.println(statisticsDisplay.getFieldsAsWeatherData());
        assertTrue(statisticsDisplay.getFieldsAsWeatherData().equals(sumWD));
    }
}
