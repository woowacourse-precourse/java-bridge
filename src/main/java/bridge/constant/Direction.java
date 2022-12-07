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

    public static Direction getDirectionByMessage(String message) {
        return Stream.of(values())
                .filter(value -> isDirectionEqual(message, value))
                .findFirst()
                .orElse(null);
    }

    private static Boolean isDirectionEqual(String message, Direction direction) {
        String directionMessage = direction.message;
        return message.equals(directionMessage);
    }

    public static Boolean isDirectionExist(String direction) {
        return Stream.of(values())
                .anyMatch(value -> direction.equals(value.message));
    }
}