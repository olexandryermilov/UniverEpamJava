package weathertask.apiwork;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import weathertask.weatherstation.WeatherData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;

public class APIAdapter {
    private String apikey;
    private String url;
    private final String USER_AGENT = "Mozilla/5.0";
    public APIAdapter(){
        Scanner sc = null;
        try {
            sc = new Scanner(new File(".\\apikey.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        apikey = sc.nextLine();
        url = "http://api.openweathermap.org/data/2.5/weather?q=Kiev&APPID=4200ff39929f7ad3057b4c1ff8d3538a";
    }
    public WeatherData getWeatherData() throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        //System.out.println("\nSending 'GET' request to URL : " + url);
        //System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(obj.openStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
            response.append("\n");
        }
        in.close();

        //print result
        System.out.println(response);
        Gson gson = new GsonBuilder().create();
        WeatherData weatherData = (WeatherData) gson.fromJson(new String(response), WeatherData.class);
        return weatherData;
    }
}
