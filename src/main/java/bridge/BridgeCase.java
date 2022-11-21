package bridge;

public enum BridgeCase {
    NOTHING(" "),
    ANSWER("O"),
    WRONG("X");

    BridgeCase(String bridgeCase){
        this.input = bridgeCase;
    }
    private final String input;

    public String getBridgeCase() {
        return input;
    }

    @Override
    public String toString() {
        return input;
    }
}
