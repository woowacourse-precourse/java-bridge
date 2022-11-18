package bridge.constant;

import java.util.Arrays;
import java.util.Optional;

public enum Direction {
    UPPER("U", 1),
    LOWER("D", 0);

    private final String capitalLetter;
    private final int bridgeNumber;

    Direction(String capitalLetter, int bridgeNumber) {
        this.capitalLetter = capitalLetter;
        this.bridgeNumber = bridgeNumber;
    }

    public static Optional<Direction> from(String capitalLetter) {
        return Arrays.stream(values())
                .filter(direction -> direction.hasCapitalLetter(capitalLetter))
                .findFirst();
    }

    public static Optional<Direction> from(int bridgeNumber) {
        return Arrays.stream(values())
                .filter(direction -> direction.hasBridgeNumber(bridgeNumber))
                .findFirst();
    }

    private boolean hasCapitalLetter(String capitalLetter) {
        return this.capitalLetter.equals(capitalLetter);
    }

    private boolean hasBridgeNumber(int bridgeNumber) {
        return this.bridgeNumber == bridgeNumber;
    }

    public String capitalLetter() {
        return capitalLetter;
    }

    public int bridgeNumber() {
        return bridgeNumber;
    }
}
