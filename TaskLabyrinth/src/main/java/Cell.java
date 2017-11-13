public class Cell {
    public int getCameFrom() {
        return cameFrom;
    }

    public void setCameFrom(int cameFrom) {
        this.cameFrom = cameFrom;
    }

    private int cameFrom;

    public Cell(int cameAt) {
        this.cameAt = cameAt;
    }

    public int getCameAt() {

        return cameAt;
    }

    public void setCameAt(int cameAt) {
        this.cameAt = cameAt;
    }

    private int cameAt;

}
