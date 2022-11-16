package bridge.utils.validator;

import bridge.utils.constants.Commons;
import bridge.utils.constants.ErrorMessages;

public class InputValidator {

    public static void bridgeSizeValidate(String bridge) {
        if (!isValidBridgeType(bridge)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BRIDGE_TYPE.getMessage());
        }
        int bridgeSize = Integer.parseInt(bridge);
        if (!isValidBridgeRange(bridgeSize)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BRIDGE_SIZE.getMessage());
        }
    }

    private static boolean isValidBridgeType(String bridgeSize) {
        return bridgeSize
                .chars()
                .allMatch(Character::isDigit);
    }

    private static boolean isValidBridgeRange(int bridgeSize) {
        return bridgeSize >= Commons.MIN_BRIDGE_RANGE.getNumber()
                && bridgeSize <= Commons.MAX_BRIDGE_RANGE.getNumber();
    }

    public static void movingValidate(String move) {
        if (!isValidMove(move)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_MOVE.getMessage());
        }
    }

    private static boolean isValidMove(String move) {
        return move.equals(Commons.UP.getCommand()) || move.equals(Commons.DOWN.getCommand());
    }

    public static void gameCommandValidate(String command) {
        if (!isValidCommand(command)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_COMMAND.getMessage());
        }
    }

    private static boolean isValidCommand(String command) {
        return command.equals(Commons.GAME_RESTART.getCommand()) || command.equals(Commons.GAME_QUIT.getCommand());
    }
}
