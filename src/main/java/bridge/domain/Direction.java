package bridge;

public enum Direction {
    UP("U"),
    DOWN("D")
    ;

    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public Direction getByDirectionString(String direction) {
        return Direction.valueOf(direction);
    }
}
