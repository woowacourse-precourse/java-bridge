package bridge.View;

import static bridge.Error.BRIDGE_SIZE_FORMAT_ERROR;
import static bridge.Error.BRIDGE_SIZE_RANGE_ERROR;

public class InputValidator {
    public static void validateBridgeSize(String bridge_size_input) {
        validateBridgeSizeFormat(bridge_size_input);
        validateBridgeSizeRange(bridge_size_input);
    }

    private static void validateBridgeSizeRange(String bridge_size_input) {
        int bridge_size = Integer.parseInt(bridge_size_input);
        if (bridge_size < 3 || bridge_size > 20) {
            throw new IllegalArgumentException(BRIDGE_SIZE_RANGE_ERROR.getMessage());
        }
    }

    private static void validateBridgeSizeFormat(String bridge_size_input) {
        if(!bridge_size_input.matches("\\d+")){
            throw new IllegalArgumentException(BRIDGE_SIZE_FORMAT_ERROR.getMessage());
        }
    }
}
