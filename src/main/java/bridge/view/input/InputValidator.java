package bridge.view.input;

import bridge.Validator;
import bridge.bridge.Direction;
import bridge.exception.ExceptionHandler;
import bridge.exception.ExceptionMessage;

public class InputValidator extends Validator {

    private static final int BRIDGE_LOWER_INCLUSIVE = 3;
    private static final int BRIDGE_UPPER_INCLUSIVE = 20;
    private static final String RETRY_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";


    public static int validateBridgeSize(int bridgeSize) {
        validateLowerBridgeSize(bridgeSize);
        validateUpperBridgeSize(bridgeSize);
        return bridgeSize;
    }

    public static String validateMoving(String moving) {
        validateMovingDirection(moving);
        return moving;
    }

    public static String validateGameCommand(String command) {
        validateRetryOrQuitCommand(command);
        return command;
    }

    private static void validateLowerBridgeSize(int bridgeSize) {
        if (bridgeSize < BRIDGE_LOWER_INCLUSIVE) {
            ExceptionHandler.throwException(new IllegalArgumentException(), ExceptionMessage.LOWER_BRIDGE_SIZE);
        }
    }

    private static void validateUpperBridgeSize(int bridgeSize) {
        if (bridgeSize > BRIDGE_UPPER_INCLUSIVE) {
            ExceptionHandler.throwException(new IllegalArgumentException(), ExceptionMessage.UPPER_BRIDGE_SIZE);
        }
    }

    private static void validateMovingDirection(String moving) {
        if (!Direction.UP.equals(moving)
                && !Direction.DOWN.equals(moving)) {
            ExceptionHandler.throwException(new IllegalArgumentException(), ExceptionMessage.MOVING_DIRECTION);
        }
    }

    private static void validateRetryOrQuitCommand(String command) {
        if (!command.equals(RETRY_COMMAND)
                && !command.equals(QUIT_COMMAND)) {
            ExceptionHandler.throwException(new IllegalArgumentException(), ExceptionMessage.GAME_COMMAND);
        }
    }
}
