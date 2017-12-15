package multithreadtask.task3;

import java.util.ArrayList;
import java.util.LinkedList;

public class Queue {
    public java.util.Queue<Monk> getQ() {
        return q;
    }

    private java.util.Queue<Monk> q;
    public Queue(){
        q= new LinkedList<>();
        for(int i=0;i<=100;i++){
            q.add(MonkFactory.nextMonk());
        }
    }
    public synchronized ArrayList<Monk> getPair() throws InterruptedException {
        while(q.size()<2){
            wait();
        }
        ArrayList<Monk> res = new ArrayList<>();
        res.add(q.poll());
        res.add(q.poll());
        System.out.println(res.get(0)+" and "+res.get(1)+" are fighting");
        notify();
        return res;
    }
    public synchronized void addWinner(Monk monk){
        System.out.println(monk+" won");
        q.add(monk);
    }
}
