package bridge;

import java.util.Arrays;

public enum Direction {
    UP(1, "U"),
    DOWN(0, "D");

    private final int directionNumber;
    private final String direction;

    Direction(int directionNumber, String direction) {
        this.directionNumber = directionNumber;
        this.direction = direction;
    }

    public static String findByDirectionNumber(int directionNumber) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.hasDirectionNumber(directionNumber))
                .findAny()
                .get().direction;
    }

    private boolean hasDirectionNumber(int directionNumber) {
        return this.directionNumber == directionNumber;
    }
}
