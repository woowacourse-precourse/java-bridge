package bridge;

public enum Map {
    CROSS_OK("O"),
    CROSS_NO("X"),
    BLANK(" "),
    BAR(" | ")
    ;


    private String symbol;

    Map(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
