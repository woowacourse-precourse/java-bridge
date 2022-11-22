package bridge.constant;

public enum BridgeSelection {
    UP("U"),
    DOWN("D");

    private final String input;

    BridgeSelection(String input) {
        this.input = input;
    }

    public String get() {
        return input;
    }
}