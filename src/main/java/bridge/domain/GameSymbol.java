package bridge.domain;

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

    public static GameSymbol conversionString(String symbol) {
        if (symbol.equals(RETRY.symbol)) {
            return RETRY;
        }
        if (symbol.equals(QUIT.symbol)) {
            return QUIT;
        }
        return NOTHING;
    }
}
