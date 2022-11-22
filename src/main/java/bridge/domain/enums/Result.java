package bridge.domain.enums;

public enum Result {
    SUCCESS("O"),
    FAIL("X"),
    NOTHING(" ");

    private String symbol;

    Result(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
