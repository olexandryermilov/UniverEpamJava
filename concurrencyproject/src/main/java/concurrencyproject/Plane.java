package concurrencyproject;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Plane implements Runnable{
    private int capacity,id;
    private Terminal terminal;
    private ArrayList<Passenger> passengers;
    private DataHolder dataHolder;
    public Plane(int id, int capacity, DataHolder dataHolder){
        this.id=id;
        this.capacity=capacity;
        this.dataHolder=dataHolder;
        passengers=new ArrayList<>();
        terminal=null;
    }
    public synchronized int addPassenger(Passenger passenger) throws InterruptedException {
        while(passengers.size()==capacity){
            wait();
        }
        System.out.println(passenger + " boarded "+this);
        passengers.add(passenger);
        notifyAll();
        return passengers.size();
    }
    public synchronized void removePassenger(int i) throws InterruptedException {
        while(passengers.size()<=i){
            wait();
        }
        System.out.println(passengers.get(i) + " left "+this);
        passengers.remove(i);
        notifyAll();
    }
    public synchronized void sitAt(Terminal terminal){
        try {
            terminal.sitAt(this);
            this.terminal=terminal;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }
    public synchronized void flyUp(){
        try {
            terminal.flyUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while(true){
            sitAt(dataHolder.getRandomTerminal());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flyUp();
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Plane " + id ;
    }
}
