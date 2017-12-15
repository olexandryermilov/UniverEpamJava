package multithreadtask.task3;

public class Monk {
    private int strength;
    private int id;
    private Monastery monastery;

    public Monk(int strength, int id, int mon) {
        this.strength = strength;
        this.id = id;
        if(mon==0)monastery=Monastery.FIRST;else monastery=Monastery.SECOND;
    }

    public int getStrength() {
        return strength;
    }

    public int getId() {
        return id;
    }

    public Monastery getMonastery() {
        return monastery;
    }

    @Override
    public String toString() {
        return "Monk{" +
                "id=" + id +
                '}';
    }
}
