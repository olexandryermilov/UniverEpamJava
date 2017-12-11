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
        state=2;
        System.out.println("Petrov has taken "+good);
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
        System.out.println("Ivanov has put "+good);
        notify();
        notifyAll();
    }
    synchronized int getCost(){
        while(state!=2){
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        state = 0;
        System.out.println("Necheporchuk got the cost : "+good.getValue());
        notify();
        notifyAll();
        return good.getValue();
    }
}
