package bridge.enums;

public enum GameMapStatus {
    PASS("O"),
    SPACE(" "),
    FAIL("X"),
    BOUNDARY_LINE(" | "),
    START_MAP("[ "),
    END_MAP(" ]");

    private String symbol;

    GameMapStatus(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol(){
        return this.symbol;
    }
}
