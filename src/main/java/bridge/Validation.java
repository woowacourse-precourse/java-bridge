package bridge;

import static bridge.Message.ERROR_INVALID_BRIDGE_SIZE;

public class Validation {
    public static void validateBridgeSize(String userInput){
        isEmpty(userInput);
        isNumeric(userInput);
        isBridgeSizeInRange(userInput);
    }
    private static void isEmpty(String userInput){
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(ERROR_INVALID_BRIDGE_SIZE);
        }
    }
    private static void isNumeric(String userInput){
        if (!userInput.matches("[0-9]+")) {
            throw new IllegalArgumentException(ERROR_INVALID_BRIDGE_SIZE);
        }
    }
    private static void isBridgeSizeInRange(String userInput){
        int bridgeSize = Integer.parseInt(userInput);
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(ERROR_INVALID_BRIDGE_SIZE);
        }
    }
}
