package bridge.ui.input.dto;

public class BridgeSize {
    private final int bridgeSize;

    public BridgeSize(int bridgeSize) {
        this.bridgeSize = bridgeSize;
    }

    public static BridgeSize from(String userInput) {
        validate(userInput);
        return new BridgeSize(Integer.parseInt(userInput));
    }
}
