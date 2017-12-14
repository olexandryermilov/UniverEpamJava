package concurrencyproject;

public class Passenger implements Runnable {
    private int id;
    private int placeNumber=-1;
    private DataHolder dataHolder;
    private Plane plane;
    public Passenger(int id, DataHolder dataHolder){
        this.id=id;
        this.dataHolder = dataHolder;
    }
    public synchronized void getOn(Plane plane){
        try{
            placeNumber=plane.addPassenger(this);
            this.plane=plane;
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void getFrom(){
        try {
            this.plane.removePassenger(placeNumber);
            this.plane=null;
            this.placeNumber=-1;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public Plane getPlane() {
        return plane;
    }

    @Override
    public void run() {
        while(true){
            getOn(dataHolder.getRandomPlane());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getFrom();
        }
    }

    @Override
    public String toString() {
        return "Passenger " + id ;
    }
}
