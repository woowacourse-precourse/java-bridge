package bridge.constant;

public enum MoveResult {

    CAN_MOVE("O"),
    CAN_NOT_MOVE("X"),
    ;

    private final String symbol;

    MoveResult(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isCanNotMove() {
        return this == CAN_NOT_MOVE;
    }

    public boolean isCanMove() {
        return this == CAN_MOVE;
    }
}
