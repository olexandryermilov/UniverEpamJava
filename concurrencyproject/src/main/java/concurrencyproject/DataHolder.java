package concurrencyproject;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class DataHolder {
    private ArrayList<Passenger> passengers;
    private ArrayList<Plane>planes;
    private ArrayList<Terminal>terminals;
    public DataHolder() throws InterruptedException {
        terminals = new ArrayList<>();
        for(int i=0;i<2;i++){
            Terminal terminal = new Terminal(i,this);
            /*Thread pThread = new Thread(terminal,terminal.toString());
            pThread.start();
            pThread.join();*/
            terminals.add(terminal);
        }
        planes = new ArrayList<>();
        for(int i=0;i<5;i++){
            Plane plane = new Plane(i, (int) (30+(new Date().getTime()%3-1)*(new Date().getTime()%10)),this);
            Thread pThread = new Thread(plane,plane.toString());
            pThread.start();
            //pThread.join();
            planes.add(plane);
        }
        passengers=new ArrayList<>();
        for (int i=0;i<100;i++){
            Passenger passenger = new Passenger(i,this);
            Thread pThread = new Thread(passenger, passenger.toString());
            pThread.start();
            //pThread.join();
            passengers.add(passenger);
        }


    }
    public Passenger getRandomPassenger(){
        return passengers.get((int) (new Date().getTime()%passengers.size()));
    }
    public Plane getRandomPlane(){
        return planes.get((int) (new Date().getTime()%planes.size()));
    }
    public Terminal getRandomTerminal(){
        return terminals.get((int) (new Date().getTime()%terminals.size()));
    }
}
