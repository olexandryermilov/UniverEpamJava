package concurrencyproject;

public class Terminal implements Runnable {
    private Plane plane;
    private int id;
    private DataHolder dataHolder;
    public Terminal(int id, DataHolder dataHolder){
        plane=null;
        this.id=id;
        this.dataHolder=dataHolder;
    }
    public synchronized void sitAt(Plane plane) throws InterruptedException {
        while(this.plane!=null){
            wait();
        }
        this.plane=plane;
        System.out.println(plane+" landed at "+this);
        notify();
    }
    public synchronized void flyUp() throws InterruptedException {
        while(this.plane==null){
            wait();
        }
        System.out.println(plane+" left "+this);
        this.plane=null;
        notify();
    }

    @Override
    public String toString() {
        return "Terminal " + id ;
    }

    @Override
    public void run() {
        while(true){

        }
    }
}
