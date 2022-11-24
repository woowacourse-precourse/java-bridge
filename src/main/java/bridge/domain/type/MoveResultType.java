package bridge.domain.type;

public enum MoveResultType {
    SUCCESS("O"),
    FAIL("X");

    final String symbol;

    MoveResultType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
