package bridge.config;

import java.util.Arrays;

public enum BridgeComponent {
    DOWN(0, "D"),
    UP(1, "U");

    private final int number;
    private final String symbol;

    BridgeComponent(int number, String symbol) {
        this.number = number;
        this.symbol = symbol;
    }

    public static String findByNumber(int requestNumber) {
        return Arrays.stream(BridgeComponent.values())
                .filter(bridgeComponent -> bridgeComponent.hasNumber(requestNumber))
                .findAny()
                .orElseThrow()
                .symbol;
    }

    private boolean hasNumber(int generateNumber) {
        return this.number == generateNumber;
    }
}