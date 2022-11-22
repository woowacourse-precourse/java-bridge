package bridge.model;

import bridge.exception.ExceptionMessages;
import java.util.Arrays;
import java.util.function.Predicate;

public enum Direction {
    U(1),
    D(0);

    private final int number;

    Direction(int number) {
        this.number = number;
    }

    public static Direction from(String name) {
        return getDirection(direction -> direction.hasName(name));
    }

    public static Direction from(int number) {
        return getDirection(direction -> direction.hasNumber(number));
    }

    private static Direction getDirection(Predicate<Direction> predicate) {
        return Arrays.stream(Direction.values())
            .filter(predicate)
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(ExceptionMessages.InvalidMoveCommand));
    }

    private boolean hasName(String name) {
        return name().equals(name);
    }

    private boolean hasNumber(int number) {
        return this.number == number;
    }
}
