package bridge.View;

import static bridge.Enum.Error.BRIDGE_SIZE_FORMAT_ERROR;
import static bridge.Enum.Error.BRIDGE_SIZE_RANGE_ERROR;

public class InputValidator {
    public static void validateBridgeSize(String bridgeSizeInput) {
        validateBridgeSizeFormat(bridgeSizeInput);
        validateBridgeSizeRange(bridgeSizeInput);
    }

    private static void validateBridgeSizeRange(String bridgeSizeInput) {
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(BRIDGE_SIZE_RANGE_ERROR.getMessage());
        }
    }

    private static void validateBridgeSizeFormat(String bridgeSizeInput) {
        if(!bridgeSizeInput.matches("\\d+")){
            throw new IllegalArgumentException(BRIDGE_SIZE_FORMAT_ERROR.getMessage());
        }
    }

    public static void validateMovingDirection(String movingDirection) {
        if(!movingDirection.matches("[UD]")){
            throw new IllegalArgumentException(BRIDGE_SIZE_RANGE_ERROR.getMessage());
        }
    }
}
