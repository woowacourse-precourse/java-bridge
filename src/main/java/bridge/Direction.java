package bridge;

import java.util.Arrays;

public enum Direction {
    U(1),
    D(0);

    private final int directionValue;

    Direction(int directionValue) {
        this.directionValue = directionValue;
    }

    public static String nameOf(int inputValue) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.getDirectionValue() == inputValue)
                .findAny()
                .get()
                .name();
    }

    public int getDirectionValue() {
        return directionValue;
    }
}
