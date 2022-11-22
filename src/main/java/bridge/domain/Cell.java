package bridge.domain;

public class Cell {

    private final String status;
    private final String direction;

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
