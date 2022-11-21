package bridge.model;

import bridge.constant.ErrorMessage;

import java.util.Arrays;

public enum Moving {
    UP(1, "U"),
    DOWN(0, "D");

    private final int command;
    private final String direction;

    Moving(int command, String direction) {
        this.command = command;
        this.direction = direction;
    }

    public static Moving of(String direction) {
        validate(direction);

        return Arrays.stream(values())
                .filter(moving -> moving.isSameDirection(direction))
                .findFirst()
                .get();
    }

    private static void validate(String direction) {
        if (direction.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BLANK_INPUT);
        }
        if (isValidMoving(direction)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MOVING_INPUT);
        }
    }

    private static boolean isValidMoving(String direction) {
        return !direction.equals(UP.direction) && !direction.equals(DOWN.direction);
    }

    public boolean isSameDirection(String direction) {
        return this.direction.equals(direction);
    }

    public boolean isUp() {
        return this == UP;
    }

    public boolean isDown() {
        return this == DOWN;
    }

    public boolean isSameCommand(int command) {
        return this.command == command;
    }
}
