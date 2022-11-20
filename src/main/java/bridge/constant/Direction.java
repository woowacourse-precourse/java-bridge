package bridge.constant;

import java.util.Objects;
import java.util.stream.Stream;

public enum Direction {
    UP(1, "U"),
    DOWN(0, "D");

    private int directionNumber;
    private String message;

    Direction(int directionNumber, String message) {
        this.directionNumber = directionNumber;
        this.message = message;
    }

    public static String getMessageByDirectionNumber(int directionNumber) {
        return Objects.requireNonNull(Stream.of(values())
                .filter(value -> value.directionNumber == directionNumber)
                .findFirst()
                .orElse(null))
                .message;
    }
}