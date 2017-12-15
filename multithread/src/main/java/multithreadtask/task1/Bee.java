package multithreadtask.task1;

import java.util.ArrayList;
import java.util.Queue;
import java.util.logging.Logger;

public class Bee implements Runnable{
    private static Logger log = Logger.getLogger(Bee.class.getName());
    private String name;
    private Queue<Task> tasks;
    private Solver solver;

    public Bee(int id, Queue<Task> tasks, Solver solver){
        this.name = "Bee " + id;
        this.tasks = tasks;
        this.solver=solver;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
        }
        while (!tasks.isEmpty() && !solver.isFound()) {
            Task currentTask;
            System.out.println(this.name + " is working");
            synchronized (tasks) {
                currentTask = tasks.poll();
            }
            if(currentTask != null) {
                if(currentTask.getX()==solver.getWinnieX()&&currentTask.getY()==solver.getWinnieY()){
                    System.out.println("Winnie's found by "+this.toString());
                    solver.setFound(true);
                    return;
                }
                System.out.println(this.name + " didn't found Winnie");
            }
        }
    }
}
