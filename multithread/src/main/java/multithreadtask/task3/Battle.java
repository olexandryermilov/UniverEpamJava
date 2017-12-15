package multithreadtask.task3;

import java.util.ArrayList;

public class Battle implements Runnable {
    private Queue queue;

    public Battle(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            ArrayList<Monk> monks = queue.getPair();
            Monk m1 = monks.get(0);
            Monk m2 = monks.get(1);
            if(m1.getStrength()>m2.getStrength()){
                queue.addWinner(m1);
            }
            else{
                queue.addWinner(m2);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
