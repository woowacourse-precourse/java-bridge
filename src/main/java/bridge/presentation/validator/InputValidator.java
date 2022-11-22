package bridge.presentation.validator;

import exception.ExceptionMessage;

public class InputValidator {

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String UP_COMMAND = "U";
    private static final String DOWN_COMMAND = "D";
    private static final String RETRY_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";

    public static void validateBridgeSize(String bridgeSize) {
        if (!isNumber(bridgeSize)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_ONE_DIGIT);
        }
        if (Integer.parseInt(bridgeSize) < MIN_BRIDGE_SIZE || Integer.parseInt(bridgeSize) > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.ESCAPE_3_TO_20);
        }
    }

    public static void validateMoving(String moving) {
        if (!moving.equals(UP_COMMAND) && !moving.equals(DOWN_COMMAND)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_ODD_MOVING);
        }
    }

    public static void validateGameCommand(String gameCommand) {
        if (!gameCommand.equals(RETRY_COMMAND) && !gameCommand.equals(QUIT_COMMAND)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_ODD_GAME_COMMAND);
        }
    }

    private static boolean isNumber(String bridgeSize) {
        return bridgeSize.chars().allMatch(Character::isDigit);
    }
}
