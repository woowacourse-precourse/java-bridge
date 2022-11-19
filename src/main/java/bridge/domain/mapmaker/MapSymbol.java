package bridge.domain.mapmaker;

public enum MapSymbol {

    PATH(" O "),
    FAIL_PATH(" X "),
    EMPTY("   "),
    START("["),
    END("]"),
    SEPARATOR("|"),
    ;

    private final String symbol;

    MapSymbol(final String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }
}
