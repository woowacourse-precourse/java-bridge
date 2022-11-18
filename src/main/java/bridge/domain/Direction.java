package bridge.domain;

import java.util.Arrays;

public enum Direction {
    UP("U", 1), DOWN("D", 0);

    private final String directionString;
    private final int directionNumber;

    Direction(String directionButton, int directionNumber) {
        this.directionString = directionButton;
        this.directionNumber = directionNumber;
    }

    public static Direction from(String button) {
        return Arrays.stream(values())
                .filter(direction -> direction.directionString.equals(button))
                .findFirst().get();
    }

    public static Direction from(int number) {
        return Arrays.stream(values())
                .filter(direction -> direction.directionNumber == number)
                .findFirst().get();
    }

    public String getDirectionString() {
        return directionString;
    }
}
