package bridge.domain;

import java.util.Objects;

public enum Direction {

    DOWN(0, "D"),
    UP(1, "U")
    ;

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

    public boolean isUp() {
        return this == UP;
    }

    public boolean isWrong(String input) {
        return !(Objects.equals(input, DOWN.position) || Objects.equals(input, UP.position));
    }

    public String getPosition() {
        return this.position;
    }

}
