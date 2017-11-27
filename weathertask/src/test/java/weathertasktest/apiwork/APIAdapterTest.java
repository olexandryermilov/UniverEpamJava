package weathertasktest.apiwork;

import org.junit.Test;
import org.mockito.internal.matchers.NotNull;
import weathertask.apiwork.APIAdapter;
import weathertask.weatherstation.WeatherData;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;


public class APIAdapterTest {
    final String RIGHT_JSON_STRING = "{\"coord\":{\"lon\":30.52,\"lat\":50.43},\"weather\":[{\"id\":804,\"main\":" +
            "\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":" +
            "{\"temp\":279.49,\"pressure\":1017,\"humidity\":93,\"temp_min\":279.15,\"temp_max\":280.15}," +
            "\"visibility\":6000,\"wind\":{\"speed\":5,\"deg\":160},\"clouds\":{\"all\":90},\"dt\":1511699400," +
            "\"sys\":{\"type\":1,\"id\":7358,\"message\":0.0021,\"country\":\"UA\",\"sunrise\":1511674214,\"" +
            "sunset\":1511704812},\"id\":703448,\"name\":\"Kiev\",\"cod\":200}";
    final String BAD_JSON_STRING = "{\"cod\":401, \"message\": \"Invalid API key. Please see http://openweathermap.org/faq#error401 for more info.\"}";

    @Test
    public void parseJSON_NotNull(){
        APIAdapter apiAdapter = new APIAdapter();
        WeatherData wd= null;
        try {
            wd = apiAdapter.parseJSON(RIGHT_JSON_STRING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(wd, is(notNullValue()));
    }
    @Test(expected = java.lang.NullPointerException.class)
    public void parseJSON_Null() throws Exception{
        APIAdapter apiAdapter = new APIAdapter();
        apiAdapter.parseJSON(BAD_JSON_STRING);
    }
    @Test
    public void getWeatherData_NotNull() throws Exception {
        APIAdapter mockAPIAdapter = mock(APIAdapter.class);
        when(mockAPIAdapter.readFromUrl()).thenReturn(RIGHT_JSON_STRING);
        APIAdapter adapter = new APIAdapter();
        WeatherData wd = null;
        try {
            wd = adapter.getWeatherData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(wd, is(notNullValue()));
    }
    @Test(expected = Exception.class)
    public void getWeatherData_GivesException_ErrorJSON() throws Exception{
        APIAdapter mockAPIAdapter = spy(new APIAdapter());
        when(mockAPIAdapter.readFromUrl()).thenReturn(BAD_JSON_STRING);
        mockAPIAdapter.getWeatherData();
    }
}
