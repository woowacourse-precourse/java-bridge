package bridge;

public enum GameSymbol {
    RETRY("R"),
    QUIT("Q"),
    NOTHING("");

    private final String symbol;

    GameSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
