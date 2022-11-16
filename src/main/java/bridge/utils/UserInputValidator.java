package bridge.utils;

public class UserInputValidator {

    private static final int MINIMUM_BRIDGE_LENGTH = 3;
    private static final int MAXIMUM_BRIDGE_LENGTH = 20;
    private static final String ERROR_MESSAGE_OUT_OF_RANGE_BRIDGE_LENGTH = "[ERROR] 다리 길이는 3이상 20이하여야 합니다.";
    private static final String ERROR_MESSAGE_NOT_DIGIT = "[ERROR] 다리 길이는 숫자만 입력 가능합니다.";

    public static void validateBridgeLength(String bridgeLength) {
        isDigit(bridgeLength);
        isValidLength(Integer.parseInt(bridgeLength));
    }

    private static void isDigit(String bridgeLength) {
        try {
            Integer.parseInt(bridgeLength);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_DIGIT);
        }
    }

    private static void isValidLength(int bridgeLength) {
        if (bridgeLength < MINIMUM_BRIDGE_LENGTH || bridgeLength > MAXIMUM_BRIDGE_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE_BRIDGE_LENGTH);
        }
    }
}
