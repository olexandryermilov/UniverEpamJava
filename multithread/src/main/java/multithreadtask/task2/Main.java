package multithreadtask.task2;

public class Main {
    public static void main(String args[]){
        Queue q = new Queue();
        new Ivanov(q);
        new Petrov(q);
        new Nechiporchuk(q);
    }
}
