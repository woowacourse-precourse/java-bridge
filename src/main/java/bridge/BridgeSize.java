package bridge;

public class BridgeSize {
    private static int bridgeSize;

    public static void validateInput(String userBridgeSize) {
        Validator.validateNumber(userBridgeSize);
        int tempBridgeSize = Converter.convertToNumber(userBridgeSize);
        Validator.validateRange(tempBridgeSize);
        bridgeSize = tempBridgeSize;
    }

    public static int getBridgeSize() {
        return bridgeSize;
    }
}
