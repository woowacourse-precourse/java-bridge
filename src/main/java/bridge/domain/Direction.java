package bridge.domain;

public enum Direction {
    UP("U"),
    DOWN("D");
    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public String toString() {
        return direction;
    }
}
