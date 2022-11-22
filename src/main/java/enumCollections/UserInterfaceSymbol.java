package enumCollections;

public enum UserInterfaceSymbol {
    START_OF_BRIDGE("[ "),
    END_OF_BRIDGE(" ]"),
    BLANK(" "),
    BRIDGE_DELIMITER(" | "),
    AVAILABLE_TO_MOVE("O"),
    UNAVAILABLE_TO_MOVE("X");

    private String symbol;

    UserInterfaceSymbol(String symbol) {
        this.symbol = symbol;
    }

    public static String getMovableSymbol(boolean moved) {
        if (moved) {
            return AVAILABLE_TO_MOVE.symbol;
        }
        return UNAVAILABLE_TO_MOVE.symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}