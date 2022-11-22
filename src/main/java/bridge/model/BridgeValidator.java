package bridge.model;

public class BridgeValidator {
    public static final int BRIDGE_SIZE_RANGE_START = 3;
    public static final int BRIDGE_SIZE_RANGE_END = 20;
    public static final String OUT_OF_RANGE_ERROR_MESSAGE = String.format("[ERROR] 다리의 길이는 %d 이상 %d 이하여야 합니다.",
            BRIDGE_SIZE_RANGE_START,
            BRIDGE_SIZE_RANGE_END);

    public static void validateBridgeSize(int bridgeSize) {
        if (bridgeSize < BRIDGE_SIZE_RANGE_START || bridgeSize > BRIDGE_SIZE_RANGE_END) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }
}
