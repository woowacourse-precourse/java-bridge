package bridge.validator;

import bridge.exception.BridgeException;


public class BridgeValidator {

    private static final int SIZE_ZERO = 0;
    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int BRIDGE_MAX_SIZE = 20;
    private static final int INDEX_ZERO = 0;

    public static int checkBridgeSize(final String userInput) {
        checkUserInputSizeZero(userInput);
        if (isNotNumber(userInput)) {
            BridgeException.isNotNumber();
        }
        return checkBridgeSizeValid(Integer.parseInt(userInput));
    }

    public static int checkBridgeIndexValid(final int size, final int index) {
        if (size <= index || index < INDEX_ZERO) {
            BridgeException.invalidBridgeIndex(size, index);
        }
        return index;
    }

    private static void checkUserInputSizeZero(final String userInput) {
        if (userInput.length() == SIZE_ZERO) {
            BridgeException.inputSizeZero();
        }
    }

    private static boolean isNotNumber(final String userInput) {
        try {
            Integer.parseInt(userInput);
            return false;
        } catch (NumberFormatException numberFormatException) {
            return true;
        }
    }

    private static int checkBridgeSizeValid(final int bridgeSize) {
        if (bridgeSize < BRIDGE_MIN_SIZE || BRIDGE_MAX_SIZE < bridgeSize) {
            BridgeException.invalidBridgeSize();
        }
        return bridgeSize;
    }
}
