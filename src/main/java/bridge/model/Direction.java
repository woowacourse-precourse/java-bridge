package bridge.model;

import static bridge.util.BridgeGameConstant.DOWN_SIGN;
import static bridge.util.BridgeGameConstant.UP_SIGN;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

public enum Direction {
    UP(UP_SIGN, 1), DOWN(DOWN_SIGN, 0), NONE("", 2);

    private final String directionName;
    private final int directionNumber;

    Direction(String directionName, int directionNumber) {
        this.directionName = directionName;
        this.directionNumber = directionNumber;
    }

    private static Direction find(Predicate<Direction> predicate) {
        return Arrays.stream(values()).filter(predicate).findAny().orElse(NONE);
    }

    public static String findDirectionNameWithDirectionNumber(int directionNumber) {
        return find(e -> Objects.equals(e.directionNumber, directionNumber)).directionName;
    }
}

