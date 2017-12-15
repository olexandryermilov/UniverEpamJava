package multithreadtask.task3;

import java.util.Date;

public class MonkFactory {
    public static int id = 0;
    public static Monk nextMonk(){
        return new Monk((int)(new Date().getTime()%200),id++,(int)(new Date().getTime()%2));
    }
}
