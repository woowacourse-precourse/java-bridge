package bridge.domain;

import java.util.Arrays;

public enum Direction {
    UP("U", 1), DOWN("D", 0);

    private final String inputLetter;
    private final int directionNumber;

    Direction(String directionButton, int directionNumber) {
        this.inputLetter = directionButton;
        this.directionNumber = directionNumber;
    }

    public static Direction from(String inputLetter) {
        return Arrays.stream(values())
                .filter(direction -> direction.inputLetter.equals(inputLetter))
                .findFirst()
                .get();
    }

    public static Direction from(int number) {
        return Arrays.stream(values())
                .filter(direction -> direction.directionNumber == number)
                .findFirst()
                .get();
    }

    public String getInputLetter() {
        return inputLetter;
    }
}
