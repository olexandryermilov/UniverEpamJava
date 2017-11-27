package weathertask.apiwork;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import weathertask.weatherstation.WeatherData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class APIAdapter {
    private String apikey;
    private String url;

    private URL obj;
    public APIAdapter(){
        Scanner sc = null;
        try {
            sc = new Scanner(new File(".\\apikey.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        apikey = sc.nextLine();
        url = "http://api.openweathermap.org/data/2.5/weather?q=Kiev&APPID="+apikey;
        try {
            obj = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public String readFromUrl() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(obj.openStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
            response.append("\n");
        }
        in.close();
        return new String(response);
    }
    public WeatherData getWeatherData() throws Exception {
        WeatherData result=null;
        try{
            result=parseJSON(readFromUrl());
        }catch (Exception e){
            throw e;
        }
        return result;
    }
    public WeatherData parseJSON(String jsonString)throws Exception{
        Gson gson = new GsonBuilder().create();
        JsonParser parser = new JsonParser();
        JsonObject object = parser.parse(jsonString).getAsJsonObject();
        JsonObject main = object.get("main").getAsJsonObject();
        double temp = gson.fromJson(main.get("temp"),Double.class);
        int pressure = gson.fromJson(main.get("pressure"),Integer.class);
        int humidity = gson.fromJson(main.get("humidity"),Integer.class);
        WeatherData weatherData = new WeatherData(temp,humidity,pressure);
        System.out.println(weatherData);
        return weatherData;
    }
    public void setObj(URL obj) {
        this.obj = obj;
    }
}
