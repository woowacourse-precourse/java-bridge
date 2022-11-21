package bridge.validator;

public class InputBridgeSizeValidator {

    public static final int MINIMUM_BRIDGE_SIZE = 3;
    public static final int MAXIMUM_BRIDGE_SIZE = 20;

    private static final String BRIDGE_SIZE_ERROR_MESSAGE = "다리 길이는 " + MINIMUM_BRIDGE_SIZE+ "부터 "+ MAXIMUM_BRIDGE_SIZE + " 사이의 숫자여야 합니다.";

    public static void validateBridgeSize(int size) {
        if (size < MINIMUM_BRIDGE_SIZE || size > MAXIMUM_BRIDGE_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR_MESSAGE);
        }
    }
}
