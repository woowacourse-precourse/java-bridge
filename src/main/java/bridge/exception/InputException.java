package bridge.exception;

public class InputException {

    private static final String INVALID_BRIDGE_SIZE_TYPE = "[ERROR] 다리의 길이는 숫자여야 합니다.";
    private static final String INVALID_BRIDGE_SIZE_RANGE = "[ERROR] 다리의 길이는 3 이상 20 이하여야 합니다.";
    private static final Integer MIN_BRIDGE_SIZE = 3;
    private static final Integer MAX_BRIDGE_SIZE = 20;

    public static void isValidBridgeSizeType(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE_TYPE);
        }
    }

    public static void isValidBridgeSizeRange(String bridgeSize) {
        if (Integer.parseInt(bridgeSize) < MIN_BRIDGE_SIZE || Integer.parseInt(bridgeSize) > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE_RANGE);
        }
    }
}
