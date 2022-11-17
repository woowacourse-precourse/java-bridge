package bridge.utils;

import static bridge.utils.Constants.*;

public class UserInputValidator {

    public static void validateBridgeSize(String bridgeSize) {
        isDigit(bridgeSize);
        isValidBridgeSize(Integer.parseInt(bridgeSize));
    }

    public static void validateSpaceToMove(String spaceToMove) {
        isValidInputSize(spaceToMove);
        isValidSpaceName(spaceToMove);
    }

    public static void validateGameCommand(String gameCommand) {
        isValidInputSize(gameCommand);
        isValidGameCommand(gameCommand);
    }

    private static void isDigit(String bridgeLength) {
        try {
            Integer.parseInt(bridgeLength);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_DIGIT);
        }
    }

    private static void isValidBridgeSize(int bridgeSize) {
        if (bridgeSize < MINIMUM_BRIDGE_SIZE || bridgeSize > MAXIMUM_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE_BRIDGE_SIZE);
        }
    }

    private static void isValidInputSize(String gameCommand) {
        if (gameCommand.length() != INPUT_GAME_COMMAND_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INPUT_SIZE);
        }
    }

    private static void isValidSpaceName(String spaceToMove) {
        if (!SPACE_NAME.contains(spaceToMove)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_SPACE_NAME);
        }
    }

    private static void isValidGameCommand(String retryCommand) {
        if (!retryCommand.equals(RETRY) && !retryCommand.equals(QUIT)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_GAME_COMMAND_NAME);
        }
    }
}
