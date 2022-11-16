package bridge.utils;

public class UserInputConvertor {
    public static int mapToBridgeLength(String bridgeLength) {
        UserInputValidator.validateBridgeLength(bridgeLength);
        return Integer.parseInt(bridgeLength);
    }
}
