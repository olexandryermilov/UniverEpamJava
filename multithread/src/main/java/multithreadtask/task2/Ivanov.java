package multithreadtask.task2;

public class Ivanov implements Runnable {
    private Queue q;
    public Ivanov(Queue q){
        this.q=q;
        new Thread(this,"Ivanov").start();
    }
    @Override
    public void run() {
        while(true){
            q.put(new Good());
        }
    }
}
