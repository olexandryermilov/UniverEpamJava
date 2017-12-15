package multithreadtask.task3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Queue q = new Queue();
        while(q.getQ().size()>1){
            Battle battle = new Battle(q);
            Thread battleThread = new Thread(battle);
            battleThread.start();
            Thread.sleep(100);
        }
        System.out.println(q.getQ().peek() + "is the winner from monastery " +q.getQ().peek().getMonastery());
    }
}
