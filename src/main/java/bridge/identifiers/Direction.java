package bridge.identifiers;

import bridge.exceptions.CustomIllegalStateException;
import bridge.exceptions.CustomInternalOperationError;

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
        if (directionValue == DOWN.asString)
            return DOWN;
        if (directionValue == UP.asString)
            return UP;
        throw new CustomIllegalStateException(
                "비정상적인 값"
        );
    }

    public static Direction parseDirection(int directionValue) {
        if (directionValue == DOWN.asInt)
            return DOWN;
        if (directionValue == UP.asInt)
            return UP;
        throw new CustomIllegalStateException(
                "비정상적인 값"
        );
    }
}
