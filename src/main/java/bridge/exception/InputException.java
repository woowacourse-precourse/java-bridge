package bridge.exception;

public class InputException {

    private static final String INVALID_BRIDGE_SIZE_TYPE = "[ERROR] 다리의 길이는 숫자여야 합니다.";

    public static void isValidBridgeSizeType(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE_TYPE);
        }
    }
}
