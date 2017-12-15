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
            Good g=new Good();
            System.out.println("Ivanov took "+g+" from base");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {

            }
            q.put(g);
            System.out.println("Ivanov given "+g+"to Petrov");
        }
    }
}
