package bridge.constant;

public enum OutputViewConstant {
    PREFIX("[ "),
    SPACE(" "),
    DIVIDING_LINE(" | "),
    SUFFIX(" ]"),
    NEW_LINE("\n"),
    ;

    private final String symbol;

    OutputViewConstant(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
