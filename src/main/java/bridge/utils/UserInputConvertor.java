package bridge.utils;

public class UserInputConvertor {
    public static int mapToBridgeSize(String bridgeSize) {
        UserInputValidator.validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }
}
