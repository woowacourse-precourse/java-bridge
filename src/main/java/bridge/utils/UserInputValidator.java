package bridge.utils;

import static bridge.utils.Constants.*;

public class UserInputValidator {

    public static void validateBridgeLength(String bridgeLength) {
        isDigit(bridgeLength);
        isValidLength(Integer.parseInt(bridgeLength));
    }

    public static void validateSpaceToMove(String spaceToMove) {
        isValidSpaceInputSize(spaceToMove);
        isValidSpaceName(spaceToMove);
    }

    private static void isDigit(String bridgeLength) {
        try {
            Integer.parseInt(bridgeLength);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_DIGIT);
        }
    }

    private static void isValidLength(int bridgeLength) {
        if (bridgeLength < MINIMUM_BRIDGE_LENGTH || bridgeLength > MAXIMUM_BRIDGE_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE_BRIDGE_LENGTH);
        }
    }

    private static void isValidSpaceInputSize(String spaceToMove) {
        if (spaceToMove.length() != SIZE_OF_SPACE_TO_MOVE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_SPACE_INPUT_SIZE);
        }
    }

    private static void isValidSpaceName(String spaceToMove) {
        if (!SPACE_NAME.contains(spaceToMove)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_SPACE_NAME);
        }
    }
}
