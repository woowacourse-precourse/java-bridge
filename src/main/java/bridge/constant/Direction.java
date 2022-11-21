package bridge.constant;

public enum Direction {
    UP("U", 1),
    DOWN("D", 0);

    private final String direction;
    private final int directionNumber;

    private Direction(String direction, int directionNumber) {
        this.direction = direction;
        this.directionNumber = directionNumber;
    }

    public String getDirection() {
        return direction;
    }

    public int getDirectionNumber() {
        return directionNumber;
    }

    public static String matchDirection(int upOrDown) {
        if (upOrDown == 0) {
            return "D";
        }
        return "U";
    }
}
