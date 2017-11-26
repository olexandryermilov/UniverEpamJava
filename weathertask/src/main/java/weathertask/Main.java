package weathertask;

import com.google.gson.Gson;
import weathertask.apiwork.APIAdapter;
import weathertask.displays.CurrentConditionsDisplay;
import weathertask.displays.ForecastDisplay;
import weathertask.displays.StatisticsDisplay;
import weathertask.weatherstation.WeatherStation;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static class Event {
        private String name;
        private String source;
        private Event(String name, String source) {
            this.name = name;
            this.source = source;
        }
        @Override
        public String toString() {
            return String.format("(name=%s, source=%s)", name, source);
        }
    }
    public static void main(String[] args){
        CurrentConditionsDisplay currentConditionsDisplay = CurrentConditionsDisplay.getInstance();
        ForecastDisplay forecastDisplay = ForecastDisplay.getInstance();
        StatisticsDisplay statisticsDisplay = StatisticsDisplay.getInstance();
        WeatherStation ws = new WeatherStation();
        ws.registerObserver(currentConditionsDisplay);
        ws.registerObserver(forecastDisplay);
        ws.registerObserver(statisticsDisplay);
        Scanner in = new Scanner(System.in);
        Date date=new Date();
        System.out.println("Enter 1 to see current conditions");
        System.out.println("Enter 2 to see forecast");
        System.out.println("Enter 3 to see statistics");
        System.out.println(ws);
        //System.exit(1);
        while (true) {
            if(new Date().getTime() % 10000 == 0){
                if(!ws.measurementsChanged())continue;
                System.out.println("Measurements changed");
                currentConditionsDisplay.print();
                forecastDisplay.print();
                statisticsDisplay.print();
            }
            /*try{
                /*String input = in.nextLine();
                int x=-1;
                if(input!=null){
                    try{
                        x= Integer.parseInt(input);
                    }catch (Exception e){
                        continue;
                    }
                }
                switch(x){
                    case 1:currentConditionsDisplay.print();break;
                    case 2:forecastDisplay.print();break;
                    case 3:statisticsDisplay.print();break;
                    default:

                throw new Exception();

            }catch (Exception e){
                continue;
            }*/
        }
    }
}
