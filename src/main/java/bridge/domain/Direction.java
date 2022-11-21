package bridge.domain;

import java.util.Arrays;

public enum Direction {
    U(1), D(0);
    private int directionCode;

    Direction(int directionCode) {
        this.directionCode = directionCode;
    }

    public static Direction from(int directionCode) {
        return Arrays.stream(Direction.values()).filter(direction -> direction.directionCode == directionCode)
                .findAny().orElseThrow(IllegalStateException::new);
    }

    public static Direction from(String direction) {
        return Direction.valueOf(direction);
    }

    public static boolean isUp(Direction now) {
        return now.equals(U);
    }

    public static boolean isDown(Direction now) {
        return now.equals(D);
    }
}
