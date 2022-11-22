package bridge.domain.model;

public enum MoveResult {
    SUCCESS(" O "),
    FAIL(" X ");

    private final String symbol;

    MoveResult(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
