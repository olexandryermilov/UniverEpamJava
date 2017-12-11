package multithreadtask.task2;

import java.util.Random;

public class Good {
    private int value;
    public Good(){
        this.value=Math.abs(new Random().nextInt())%100;
    }
    public int getValue(){
        return value;
    }

    @Override
    public String toString() {
        return "Good{" +
                "value=" + value +
                '}';
    }
}
