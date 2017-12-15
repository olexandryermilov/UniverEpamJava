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
            Good g = q.get();
            System.out.println("Nechiporchuk accepted "+g+" from Petrov");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Nechiporchuk: cost equals "+g.getValue());
        }
    }
}
