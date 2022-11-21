package bridge.model;

public enum Direction {
    DOWN(0, "D"), UP(1, "U");

    private final int bridgeNumber;
    private final String symbol;

    Direction(int bridgeNumber, String symbol) {
        this.bridgeNumber = bridgeNumber;
        this.symbol = symbol;
    }

    public static Direction fromBridgeNumber(int bridgeNumber){
        for (Direction direction : values()) {
            if (direction.bridgeNumber == bridgeNumber) {
                return direction;
            }
        }

        throw new IllegalArgumentException(bridgeNumber + "는 유효하지 않은 값입니다.");
    }

    public static Direction fromSymbol(String symbol) {
        for (Direction direction : values()) {
            if (direction.symbol.equals(symbol)){
                return direction;
            }
        }

        throw new IllegalArgumentException(symbol + "는 유효하지 않은 값입니다.");
    }

    public String getSymbol() {
        return symbol;
    }
}
