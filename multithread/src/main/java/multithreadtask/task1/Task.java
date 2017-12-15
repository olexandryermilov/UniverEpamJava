package multithreadtask.task1;

import java.util.ArrayList;

public class Task {

    private int x,y,id;

    public Task(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                '}';
    }
}
