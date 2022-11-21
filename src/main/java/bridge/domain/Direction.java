package bridge.domain;

public enum Direction {
    UP("U", 1),
    DOWN("D", 0);
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
