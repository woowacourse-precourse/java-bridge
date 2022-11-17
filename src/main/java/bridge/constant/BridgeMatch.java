package bridge.constant;

public enum BridgeMatch {

    CAN_MOVE("O"),
    CAN_NOT_MOVE("X"),
    ;

    private final String symbol;

    BridgeMatch(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
