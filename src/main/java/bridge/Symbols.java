package bridge;

public enum Symbols {
    UPPER("U"),
    DOWN("D"),
    RETRY("R"),
    QUIT("Q");

    private final String symbol;

    Symbols(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
