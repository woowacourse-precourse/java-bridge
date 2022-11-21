package bridge;

public enum ResultSymbol {
    SUCCESS(" O "),
    FAIL(" X "),
    NOTHING(" ");

    private final String symbol;
    ResultSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
