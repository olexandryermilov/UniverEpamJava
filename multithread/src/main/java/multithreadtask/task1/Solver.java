package multithreadtask.task1;


import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Solver {

    public boolean isFound() {
        return isFound;
    }

    public void setFound(boolean found) {
        isFound = found;
    }
    private int winnieX;
    private int winnieY;
    private int sizeX=5,sizeY=5;
    private boolean isFound;
    private int bees=10;
    private Queue<Task> tasks;
    public LinkedList<Task> initTasks(){
        LinkedList<Task> rtasks = new LinkedList<>();
        for(int i=0;i<100;i++){
            int x= (int) ((i+new Date().getTime())%sizeX);
            int y= (int) ((((i+new Date().getTime())%sizeY)*((new Date().getTime()+i)%(sizeX+3)))%sizeY);
            Task task = new Task(x,y,i);
            rtasks.add(task);
        }
        return rtasks;
    }
    public Solver(){
        winnieX= (int) (new Date().getTime()%sizeX);
        winnieY= (int) (((new Date().getTime()%sizeY)*(new Date().getTime()%(sizeX+3)))%sizeY);
        try {
            Thread.sleep(2123);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tasks=initTasks();
        for(int i=0;i<bees;i++){
            Bee bee = new Bee(i,tasks,this);
            new Thread(bee,bee.toString()).start();
        }
    }

    public int getWinnieX() {
        return winnieX;
    }

    public int getWinnieY() {
        return winnieY;
    }
}
