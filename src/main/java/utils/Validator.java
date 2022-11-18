package utils;

public class Validator {
    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자로 이루어진 다리 길이를 입력해야합니다.";
    private static final String INVALID_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 다리의 길이는 3 이상 20 이하여야 합니다.";

    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;

    private static final String MATCHER = "[+-]?\\d*(\\.\\d+)?";

    public static boolean isValidBridgeSize(String BridgeSize) {
        return isNumber(BridgeSize) && isValidSizeRange(BridgeSize);
    }

    private static boolean isNumber(String bridgeSize) {
        try {
            if (!bridgeSize.matches(MATCHER)) {
                throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        return true;
    }

    private static boolean isValidSizeRange(String bridgeSize) {
        try {
            if (Integer.parseInt(bridgeSize) < MINIMUM_BRIDGE_SIZE || Integer.parseInt(bridgeSize) > MAXIMUM_BRIDGE_SIZE) {
                throw new IllegalArgumentException(INVALID_NUMBER_RANGE_ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        return true;
    }
}
