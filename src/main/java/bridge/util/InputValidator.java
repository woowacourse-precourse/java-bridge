package bridge.util;

import static bridge.constant.BridgeConstant.QUIT;
import static bridge.constant.BridgeConstant.RETRY;
import static bridge.type.MovingType.DOWN;
import static bridge.type.MovingType.UP;

import bridge.type.ErrorType;

public class InputValidator {

    private static final String REGEX = "[0-9]+";

    public static int validateDigit(String input) throws IllegalArgumentException {
        if (!input.matches(REGEX)) {
            throw new IllegalArgumentException(ErrorType.DIGIT_ERROR.printError());
        }
        return Integer.parseInt(input);
    }

    public static void validateMoving(String input) {
        if (!input.equals(UP.getKey()) && !input.equals(DOWN.getKey())) {
            throw new IllegalArgumentException(ErrorType.MOVING_ERROR.printError());
        }
    }

    public static void validateRetryOrExit(String input) {
        if (!input.equals(RETRY) && !input.equals(QUIT)) {
            throw new IllegalArgumentException(ErrorType.COMMAND_ERROR.printError());
        }
    }
}
