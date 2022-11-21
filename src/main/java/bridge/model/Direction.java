package bridge.model;

import bridge.error.DirectionError;

public enum Direction {
    DOWN(0, "D"), UP(1, "U");

    private final int bridgeNumber;
    private final String symbol;

    Direction(int bridgeNumber, String symbol) {
        this.bridgeNumber = bridgeNumber;
        this.symbol = symbol;
    }

    public static Direction fromBridgeNumber(int bridgeNumber) {
        for (Direction direction : values()) {
            if (direction.bridgeNumber == bridgeNumber) {
                return direction;
            }
        }

        throw new IllegalArgumentException(DirectionError.INVALID_NUMBER.getMessage());
    }

    public static Direction fromSymbol(String symbol) {
        for (Direction direction : values()) {
            if (direction.symbol.equals(symbol)) {
                return direction;
            }
        }

        throw new IllegalArgumentException(DirectionError.INVALID_SYMBOL.getMessage());
    }

    public String getSymbol() {
        return symbol;
    }
}
