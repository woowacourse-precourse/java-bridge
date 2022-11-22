package bridge.domain.gameManagement;

public class BridgeMakingValidator {
    private static final String EMPTY_BRIDGE_SIZE_ERROR_MESSAGE = "[ERROR] 다리 길이가 입력되지 않았습니다.";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자가 아니거나 숫자가 아닌 문자가 포함되어 있습니다.";
    private static final String BRIDGE_SIZE_OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR]  다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    private static final int BRIDGE_SIZE_RANGE_FIRST_VALUE = 3;
    private static final int BRIDGE_SIZE_RANGE_LAST_VALUE = 20;

    public static void validate(String bridgeSize) {
        validateEmptyBridgeSize(bridgeSize);

        validateOnlyNumber(bridgeSize);

        validateBridgeSizeRange(bridgeSize);
    }

    public static void validateEmptyBridgeSize(String bridgeSize) {
        if (bridgeSize.isEmpty() || bridgeSize == null) {
            throw new IllegalArgumentException(EMPTY_BRIDGE_SIZE_ERROR_MESSAGE);
        }
    }

    public static void validateOnlyNumber(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void validateBridgeSizeRange(String bridgeSize) {
        int size = Integer.parseInt(bridgeSize);

        if (size < BRIDGE_SIZE_RANGE_FIRST_VALUE || size > BRIDGE_SIZE_RANGE_LAST_VALUE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }
}
