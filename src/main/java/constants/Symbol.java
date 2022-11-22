package constants;

public enum Symbol {

    START("[ "),
    END(" ]"),
    SPLIT(" | "),
    UN_CHOSEN(" "),
    CAN_MOVE("O"),
    CANT_MOVE("X");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}