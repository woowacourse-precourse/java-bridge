package bridge.config;

public enum BridgeConfiguration {
    LEFT_SQUARE_BRACKET("[ "),
    RIGHT_SQUARE_BRACKET(" ]"),
    VERTICAL_BAR(" | "),
    BRIDGE_EMPTY_EXPRESSION(" "),
    BRIDGE_CORRECT_EXPRESSION("O"),
    BRIDGE_NOT_CORRECT_EXPRESSION("X");
    private final String config;

    BridgeConfiguration(String config) {
        this.config = config;
    }

    public String getConfig() {
        return config;
    }
}
