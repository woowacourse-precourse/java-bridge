package bridge.identifiers;

import java.util.Objects;

public enum Direction {
    DOWN(0, "D"), UP(1, "U");

    private int asInt;
    private String asString;

    Direction(int intValue, String stringValue) {
        this.asInt = intValue;
        this.asString = stringValue;
    }

    public int getAsInt() {
        return asInt;
    }

    public String getAsString() {
        return asString;
    }

    public static Direction parseDirection(String directionValue) {
        if (Objects.equals(directionValue, DOWN.asString))
            return DOWN;
        if (Objects.equals(directionValue, UP.asString))
            return UP;
        throw new IllegalArgumentException(
                DOWN.asString + " 또는 " + UP.asString + " 을 입력해야 합니다."
        );
    }

    public static Direction parseDirection(int directionValue) {
        if (directionValue == DOWN.asInt)
            return DOWN;
        if (directionValue == UP.asInt)
            return UP;
        throw new IllegalStateException(
                DOWN.asInt + " 또는 " + UP.asInt + " 을 입력해야 합니다."
        );
    }
}
