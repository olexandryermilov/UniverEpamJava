package concurrencyproject;

public class Main {
    public static void main (String[] args){
        try {
            new DataHolder();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
