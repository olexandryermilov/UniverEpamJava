package multithreadtask.task2;

public class Main {
    public static void main(String args[]){
        Queue q1 = new Queue();
        Queue q2 = new Queue();
        new Ivanov(q1);
        new Petrov(q1,q2);
        new Nechiporchuk(q2);
    }
}
