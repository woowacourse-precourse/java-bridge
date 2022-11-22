package bridge.Enum;

public enum BridgeCase {
    NOTHING(" "),
    ANSWER("O"),
    WRONG("X");

    BridgeCase(String bridgeCase){
        this.input = bridgeCase;
    }
    private final String input;

    @Override
    public String toString() {
        return input;
    }
}
