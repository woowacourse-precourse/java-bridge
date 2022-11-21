package bridge.domain;

import java.util.Arrays;

public enum Direction {
    UP(1, "U"),
    DOWN(0, "D");

    private final int bridgeNumber;
    private final String initial;

    Direction(int bridgeNumber, String initial) {
        this.bridgeNumber = bridgeNumber;
        this.initial = initial;
    }

    public static String getInitialByBridgeNumber(int bridgeNumber) {
        return Arrays.stream(values())
                .filter(direction -> direction.bridgeNumber == bridgeNumber)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .initial;
    }
}
