package bridge;

public enum ResultSymbol {
    SUCCESS(" O "),
    FAIL(" X "),
    NOTHING(" ");

    private String symbol;
    ResultSymbol(String symbol) {
        this.symbol = symbol;
    }
}
