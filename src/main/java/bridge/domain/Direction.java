package bridge.domain;

import java.util.Arrays;

public enum Direction {
    UP("U", 1), DOWN("D", 0);

    private final String directionButton;
    private final int directionNumber;

    Direction(String directionButton, int directionNumber) {
        this.directionButton = directionButton;
        this.directionNumber = directionNumber;
    }

    public static Direction from(String button) {
        return Arrays.stream(values())
                .filter(direction -> direction.directionButton.equals(button))
                .findFirst().get();
    }

    public static Direction from(int number) {
        return Arrays.stream(values())
                .filter(direction -> direction.directionNumber == number)
                .findFirst().get();
    }

    public String getDirectionButton() {
        return directionButton;
    }
}
