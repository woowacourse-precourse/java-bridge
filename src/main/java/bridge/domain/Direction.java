package bridge.domain;

public enum Direction {
    U("U", 1),
    D("D", 0);
    private String direction;
    private int binaryDirection;

    Direction(String direction, int binaryDirection) {
        this.direction = direction;
        this.binaryDirection = binaryDirection;
    }

    public String toString() {
        return direction;
    }
}
