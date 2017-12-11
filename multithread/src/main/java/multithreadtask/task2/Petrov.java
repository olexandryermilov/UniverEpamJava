package multithreadtask.task2;

public class Petrov implements Runnable{
    private Queue q;
    public Petrov(Queue q){
        this.q=q;
        new Thread(this,"Petrov").start();
    }
    @Override
    public void run() {
        while(true){
            q.get();
        }
    }
}
