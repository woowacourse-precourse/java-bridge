package bridge.domain;

import static bridge.constant.ExceptionMessage.MOVING_DIRECTION_EXCEPTION_MESSAGE;

import java.util.Arrays;

public enum Direction {
    UP("U", 1), DOWN("D", 0);

    private final String command;
    private final int directionNumber;

    Direction(String command, int directionNumber) {
        this.command = command;
        this.directionNumber = directionNumber;
    }

    public static Direction from(String inputLetter) {
        return Arrays.stream(values())
                .filter(direction -> direction.command.equals(inputLetter))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(MOVING_DIRECTION_EXCEPTION_MESSAGE));
    }

    public static Direction from(int number) {
        return Arrays.stream(values())
                .filter(direction -> direction.directionNumber == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(MOVING_DIRECTION_EXCEPTION_MESSAGE));
    }

    public static boolean hasInputLetter(String inputLetter) {
        return Arrays.stream(values())
                .anyMatch(direction -> direction.command.equals(inputLetter));
    }

    public String getCommand() {
        return command;
    }
}
