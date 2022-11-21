package bridge.domain;

import static bridge.util.Error.NOT_U_NOR_D;

public enum Direction {
    UP("U"), DOWN("D");

    private final String compact;

    Direction(String compact) {
        this.compact = compact;
    }

    public static String valueOf(int number) {
        if (number == 0) {
            return Direction.UP.compact;
        } else if (number == 1) {
            return Direction.DOWN.compact;
        }
        throw new IllegalArgumentException(NOT_U_NOR_D.toString());
    }
}
