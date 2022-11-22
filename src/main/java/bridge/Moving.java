package bridge;

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
        return Arrays.stream(values())
                .filter(moving -> moving.isSameDirection(direction))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_MOVING_INPUT));
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

    public String getDirection() {
        return direction;
    }
}
