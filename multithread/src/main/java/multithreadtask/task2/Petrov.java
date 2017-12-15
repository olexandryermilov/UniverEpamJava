package multithreadtask.task2;

public class Petrov implements Runnable{
    private Queue q1;
    private Queue q2;
    public Petrov(Queue q1, Queue q2){
        this.q1=q1;
        this.q2=q2;
        new Thread(this,"Petrov").start();
    }
    @Override
    public void run() {
        while(true){
            Good g =q1.get();
            System.out.println("Petrov accepted "+g);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            q2.put(g);
            System.out.println("Petrov given "+g+"to Nechiporchuk");
        }
    }
}
