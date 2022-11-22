package bridge.domain.enums;

import bridge.constants.ErrorMessages;
import java.util.Arrays;

public enum Direction {
    UP("U", 1),
    DOWN("D", 0);

    private final String command;
    private final int number;

    private Direction(String command, int number) {
        this.command = command;
        this.number = number;
    }

    public static Direction of(String input) {
        return Arrays.stream(values())
                .filter(direction -> isSameCommand(direction, input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessages.INVALID_MOVE_COMMAND));
    }

    private static boolean isSameCommand(Direction direction, String input) {
        return direction.getCommand().equals(input);
    }

    public String getCommand() {
        return command;
    }

    public int getNumber() {
        return number;
    }
}
