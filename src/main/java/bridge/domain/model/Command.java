package bridge.domain.model;

public enum Command {
    RETRY("R"),
    QUIT("Q");

    private final String symbol;

    Command(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
