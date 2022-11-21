package bridge;

public class Cell {

    private String status;
    private String direction;

    public Cell(String status, String direction) {
        this.status = status;
        this.direction = direction;
    }

    public String getStatus() {
        return status;
    }

    public String getDirection() {
        return direction;
    }
}
