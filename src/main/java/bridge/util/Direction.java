package bridge.util;

public enum Direction {
    UP("U"), DOWN("D");

    private final String to;

    Direction(String to) {
        this.to = to;
    }

    public static String valueOf(int number) {
        if (number == 0) {
            return Direction.UP.to;
        } else if (number == 1) {
            return Direction.DOWN.to;
        }
        throw new IllegalArgumentException();
    }
}
