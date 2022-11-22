package bridge.domain.constants;

public enum BlockSymbol {
    UP("U"),
    DOWN("D"),
    CORRECT("O"),
    WRONG("X"),
    BLANK(" ");

    private String symbol;
    BlockSymbol(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
