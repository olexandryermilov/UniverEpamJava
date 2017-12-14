package jdbctask.data;

public class Station {
    private int id, r_id;
    private String name;

    public Station(int id, int r_id, String name) {
        this.id = id;
        this.r_id = r_id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Station station = (Station) o;

        if (id != station.id) return false;
        if (r_id != station.r_id) return false;
        return name.equals(station.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + r_id;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", r_id=" + r_id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
