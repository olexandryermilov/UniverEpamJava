package multithreadtask.task2;

public class Nechiporchuk implements Runnable{
    private Queue q;
    public Nechiporchuk(Queue q){
        this.q=q;
        new Thread(this,"Nechiporchuk").start();
    }
    @Override
    public void run() {
        while(true){
            q.getCost();
        }
    }
}
