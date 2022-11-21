package bridge.domain;

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
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Direction from(int number) {
        return Arrays.stream(values())
                .filter(direction -> direction.directionNumber == number)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static boolean hasInputLetter(String inputLetter) {
        return Arrays.stream(values())
                .anyMatch(direction -> direction.command.equals(inputLetter));
    }

    public String getCommand() {
        return command;
    }
}
