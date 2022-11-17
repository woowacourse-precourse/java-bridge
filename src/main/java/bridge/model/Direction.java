package bridge.model;

public enum Direction {

    UP("U"),
    DOWN("D");

    private final String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

}
