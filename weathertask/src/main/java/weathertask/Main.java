package weathertask;

import weathertask.apiwork.APIAdapter;
import weathertask.displays.CurrentConditionsDisplay;
import weathertask.displays.ForecastDisplay;
import weathertask.displays.StatisticsDisplay;
import weathertask.weatherstation.WeatherStation;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        CurrentConditionsDisplay currentConditionsDisplay = CurrentConditionsDisplay.getInstance();
        ForecastDisplay forecastDisplay = ForecastDisplay.getInstance();
        StatisticsDisplay statisticsDisplay = StatisticsDisplay.getInstance();
        WeatherStation ws = new WeatherStation();
        Scanner in = new Scanner(System.in);
        Date date=new Date();
        System.out.println("Enter 1 to see current conditions");
        System.out.println("Enter 2 to see forecast");
        System.out.println("Enter 3 to see statistics");
        ws.measurementsChanged();
        System.out.println(ws);
        System.exit(1);
        while (true) {
            long l = new Date().getTime();
            System.out.println(l);
            if(new Date().getTime() % 60000 == 0){
                ws.measurementsChanged();
                System.out.println("Measurements changed");
            }
            try{
                int x =1;// in.nextInt();
                switch(x){
                    case 1:currentConditionsDisplay.print();break;
                    case 2:forecastDisplay.print();break;
                    case 3:statisticsDisplay.print();break;
                    default:

            }
            }catch (Exception e){
                continue;
            }
        }
    }
}
