package bridge.domain;

public enum ResultSymbol {
    SUCCESS("O", "성공"),
    FAIL("X", "실패"),
    NOTHING(" ", "");

    private final String symbol;
    private final String status;
    ResultSymbol(String symbol, String status) {
        this.symbol = symbol;
        this.status = status;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getStatus() {
        return status;
    }
}
