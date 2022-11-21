package bridge.utils.validator;

import bridge.utils.constants.Comments;
import bridge.utils.constants.Commons;
import bridge.utils.constants.ErrorMessages;

public class InputValidator {

    public static void bridgeSizeValidate(String bridge) {
        if (!isValidBridgeType(bridge)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_BRIDGE_TYPE.getMessage());
        }
        int bridgeSize = Integer.parseInt(bridge);
        if (!isValidBridgeRange(bridgeSize)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_BRIDGE_SIZE.getMessage());
        }
    }

    private static boolean isValidBridgeType(String bridgeSize) {
        return bridgeSize.length() >= 1 && bridgeSize.chars().allMatch(Character::isDigit);
    }

    private static boolean isValidBridgeRange(int bridgeSize) {
        return bridgeSize >= Commons.MIN_BRIDGE_RANGE.getNumber()
                && bridgeSize <= Commons.MAX_BRIDGE_RANGE.getNumber();
    }

    public static void movingValidate(String move) {
        if (!isValidMove(move)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_MOVE.getMessage());
        }
    }

    private static boolean isValidMove(String move) {
        return move.equals(Comments.UP.getComment()) || move.equals(Comments.DOWN.getComment());
    }

    public static void gameCommandValidate(String command) {
        if (!isValidCommand(command)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_COMMAND.getMessage());
        }
    }

    private static boolean isValidCommand(String command) {
        return command.equals(Comments.GAME_RESTART.getComment()) || command.equals(Comments.GAME_QUIT.getComment());
    }
}
