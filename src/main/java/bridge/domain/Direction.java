package bridge.domain;

import bridge.constants.ErrorMessages;
import java.util.Arrays;

public enum Direction {
    UP("U", 1),
    DOWN("D", 0),
    UNKNOWN("", 9);

    private final String command;
    private final int number;

    private Direction(String command, int number) {
        this.command = command;
        this.number = number;
    }

    public static Direction of(String input) {
        Direction direction = Arrays.stream(values())
                .filter(command -> command.getCommand().equals(input))
                .findAny()
                .orElse(UNKNOWN);
        if (direction == UNKNOWN) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_MOVE_COMMAND);
        }
        return direction;
    }

    public String getCommand() {
        return command;
    }

    public int getNumber() {
        return number;
    }
}
