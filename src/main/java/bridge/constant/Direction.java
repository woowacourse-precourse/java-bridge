package bridge.constant;

import java.util.Arrays;
import java.util.Optional;

public enum Direction {
    UPPER("U"),
    LOWER("D");

    private final String capitalLetter;

    Direction(String capitalLetter) {
        this.capitalLetter = capitalLetter;
    }

    public static Optional<Direction> from(String capitalLetter) {
        return Arrays.stream(values())
                .filter(direction -> direction.hasCapitalLetter(capitalLetter))
                .findFirst();
    }

    private boolean hasCapitalLetter(String capitalLetter) {
        return this.capitalLetter.equals(capitalLetter);
    }
}
