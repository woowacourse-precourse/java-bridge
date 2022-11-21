package bridge.model;

import java.util.Arrays;

public enum Direction {

    LOWER_DIRECTION(0, "D"),
    UPPER_DIRECTION(1, "U"),
    EMPTY(-1, "없음");

    private final int directionNumber;
    private final String directionString;


    Direction(int directionNumber, String directionString) {
        this.directionNumber = directionNumber;
        this.directionString = directionString;
    }

    public static String findByDirectionString(int directionNumber) {
        return Arrays.stream(Direction.values())
                .filter(bridge -> bridge.directionNumber == directionNumber)
                .findAny().get().directionString;

    }
}