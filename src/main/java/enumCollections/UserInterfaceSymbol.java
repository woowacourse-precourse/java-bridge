package enumCollections;

public enum UserInterfaceSymbol {
    START_OF_BRIDGE("["),
    END_OF_BRIDGE("]\n"),
    BLANK(" "),
    BRIDGE_DELIMITER("|"),
    AVAILABLE_TO_MOVE("O"),
    UNAVAILABLE_TO_MOVE("X");

    private String symbol;

    UserInterfaceSymbol(String symbol) {
        this.symbol = symbol;
    }

    public static String get(UserInterfaceSymbol occasion) {
        return occasion.symbol;
    }
}
