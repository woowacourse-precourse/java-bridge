package bridge.enums;

public enum GameMapStatus {
    PASS("O"),
    SPACE(" "),
    FAIL("X"),
    BOUNDARY_LINE(" | "),
    START_MAP("[ "),
    END_MAP(" ]"),
    NEXT_LINE("\n");

    private final String symbol;

    GameMapStatus(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
