package multithreadtask.task2;


public class Queue {
    private Good good;
    private int state;
    public Queue(){
        state=0;
    }
    synchronized Good get(){
        while(state!=1){
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        state=0;
        notify();
        notifyAll();
        return good;
    }
    synchronized void put(Good good){
        while(state!=0){
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        state=1;
        this.good=good;
        notify();
        notifyAll();
    }

}
