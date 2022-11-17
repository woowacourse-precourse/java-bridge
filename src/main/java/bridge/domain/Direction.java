package bridge.domain;

import java.util.Objects;

public enum Direction {

    DOWN(0, "D"),
    UP(1, "U");

    private final int number;
    private final String position;

    Direction(int number, String position) {
        this.number = number;
        this.position = position;
    }

    public static String getPosition(int upDown) {
        if (upDown == DOWN.number) {
            return DOWN.position;
        }
        return UP.position;
    }

    public static Direction getPosition(String upDown) {
        validateInput(upDown);
        if (Objects.equals(upDown, DOWN.position)) {
            return DOWN;
        }
        return UP;
    }

    public boolean isUp() {
        return this == UP;
    }

    private static void validateInput(String input) {
        if (Objects.equals(input, DOWN.position) || Objects.equals(input, UP.position)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public String getPosition() {
        return this.position;
    }

}
