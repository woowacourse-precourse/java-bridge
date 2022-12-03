package bridge.view;

import bridge.message.ErrorMessage;
import bridge.message.Message;

public class Validator {
    public static void validateBridgeSize(String bridgeSize) {
        if (isNotNumber(bridgeSize)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_LENGTH_IS_NOT_DIGIT.getErrorMessage());
        }
        if (isLengthOutOfRange(Integer.parseInt(bridgeSize))) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_LENGTH_OUT_OF_RANGE.getErrorMessage());
        }
    }

    private static boolean isNotNumber(String bridgeSize) {
        return !bridgeSize.matches("^-?[0-9]+$");
    }

    private static boolean isLengthOutOfRange(int bridgeSize) {
        return bridgeSize < 3 || bridgeSize > 20;
    }

    public static void validateMoving(String moving) {
        if (isNotUD(moving)) {
            throw new IllegalArgumentException(ErrorMessage.MOVING_IS_NOT_U_D.getErrorMessage());
        }
    }

    private static boolean isNotUD(String moving) {
        return !moving.equals(Message.UP.getMessage()) && !moving.equals(Message.DOWN.getMessage());
    }

    public static void validateGameCommand(String gameCommand) {
        if (isNotRQ(gameCommand)) {
            throw new IllegalArgumentException(ErrorMessage.GAME_COMMAND_IS_NOT_Q_R.getErrorMessage());
        }
    }

    private static boolean isNotRQ(String gameCommand) {
        return !gameCommand.equals(Message.RETRY.getMessage()) && !gameCommand.equals(Message.QUIT.getMessage());
    }
}
