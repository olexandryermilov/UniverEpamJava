package jdbctask.data;

public class Railway {
    private int id;
    private String name;

    public Railway(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Railway railway = (Railway) o;

        if (id != railway.id) return false;
        return name.equals(railway.name);
    }

    @Override
    public String toString() {
        return "Railway{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
