package bridge.view;

import bridge.util.BridgeSize;
import bridge.util.ExceptionPhrases;

public class InputException {
    public static void userInputEmptyException(String userInput) {
        if (userInput.isEmpty() || userInput.isBlank()) {
            throw new IllegalArgumentException(ExceptionPhrases.IS_EMPTY_INPUT.getPharases());
        }
    }

    public static void notNumberException(String userInput) {
        userInput.chars().forEach(eachInput -> {
            if (!isNumber(eachInput)) {
                throw new IllegalArgumentException(ExceptionPhrases.IS_NOT_NUMBER.getPharases());
            }
        });
    }

    public static boolean isNumber(int eachInput) {
        return Character.isDigit(eachInput);
    }

    public static void outOfBridgeSizeException(int userInput) {
        if (userInput < BridgeSize.BRIDGE_MIN_SIZE.getSize() || userInput > BridgeSize.BRIDGE_MAX_SIZE.getSize()) {
            throw new IllegalArgumentException(ExceptionPhrases.IS_OUT_OF_SIZE.getPharases());
        }
    }
}
