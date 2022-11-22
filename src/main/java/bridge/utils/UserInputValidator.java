package bridge.utils;

import java.util.regex.Pattern;

import static bridge.utils.Constants.*;

public class UserInputValidator {

    public static void validateBridgeSize(String bridgeSize) {
        isDigit(bridgeSize);
        isValidBridgeSize(Integer.parseInt(bridgeSize));
    }

    public static void validateSpaceToMove(String spaceToMove) {
        if (!SPACE_NAME.contains(spaceToMove)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_SPACE_NAME);
        }
    }

    public static void validateGameCommand(String gameCommand) {
        if (!gameCommand.equals(RETRY) && !gameCommand.equals(QUIT)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_GAME_COMMAND_NAME);
        }
    }

    private static void isDigit(String bridgeLength) {
        if (!Pattern.matches(DIGIT_PATTERN, bridgeLength)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_DIGIT);
        }
    }

    private static void isValidBridgeSize(int bridgeSize) {
        if (bridgeSize < MINIMUM_BRIDGE_SIZE || bridgeSize > MAXIMUM_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE_BRIDGE_SIZE);
        }
    }
}
