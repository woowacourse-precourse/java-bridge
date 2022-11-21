package bridge.enums;

public enum BridgeViewComponent {

    RIGHT_BRIDGE(" O"),
    BLANK_BRIDGE("  "),
    WRONG_BRIDGE(" X"),
    BRIDGE_CONNECTOR(" |"),
    BRACKET_STARTED("["),
    BRACKET_FINISHER(" ]"),
    LINE_DIVIDER("\n");

    private String symbol;

    private BridgeViewComponent(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol(){
        return this.symbol;
    }
}
