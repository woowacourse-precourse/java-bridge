package bridge;

public class BridgeSize {
    private int bridgeSize;

    public BridgeSize(String userBridgeSize) {
        Validator.validateNumber(userBridgeSize);
        int tempBridgeSize = Converter.convertToNumber(userBridgeSize);
        Validator.validateRange(tempBridgeSize);
        bridgeSize = tempBridgeSize;
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
