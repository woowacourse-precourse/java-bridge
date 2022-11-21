package bridge.UserInput;

public enum BridgeSelection {
    Up("U"),
    Down("D");

    private final String input;

    BridgeSelection(String input) {
        this.input = input;
    }

    public String get() {
        return input;
    }
}