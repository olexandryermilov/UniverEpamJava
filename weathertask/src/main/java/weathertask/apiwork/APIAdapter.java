package weathertask.apiwork;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import weathertask.weatherstation.WeatherData;
import weathertask.weatherstation.WeatherStation;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Random;
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
    final static Random random = new Random(new Date().getTime());
    private int getNextRandom(int mod){
        return Math.abs(random.nextInt())%mod;
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
        //System.out.println(response);
        Gson gson = new GsonBuilder().create();
        //WeatherData weatherData = (WeatherData) gson.fromJson(new String(response), WeatherData.class);
        JsonReader reader = new JsonReader(new StringReader(new String(response)));
        //handleObject(reader);

        return new WeatherData(getNextRandom(60)-20,getNextRandom(90)+5,getNextRandom(150)+600);// weatherData;
    }
    private static void handleObject(JsonReader reader) throws IOException
    {
        reader.beginObject();
        while (reader.hasNext()) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.BEGIN_ARRAY))
                handleArray(reader);
            else if (token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
                return;
            } else
                handleNonArrayToken(reader, token);
        }

    }

    public static void handleArray(JsonReader reader) throws IOException
    {
        reader.beginArray();
        while (true) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.END_ARRAY)) {
                reader.endArray();
                break;
            } else if (token.equals(JsonToken.BEGIN_OBJECT)) {
                handleObject(reader);
            } else if (token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
            } else
                handleNonArrayToken(reader, token);
        }
    }

    public static void handleNonArrayToken(JsonReader reader, JsonToken token) throws IOException
    {
        if (token.equals(JsonToken.NAME))
            System.out.println(reader.nextName());
        else if (token.equals(JsonToken.STRING))
            System.out.println(reader.nextString());
        else if (token.equals(JsonToken.NUMBER))
            System.out.println(reader.nextDouble());
        else
            reader.skipValue();
    }

}
