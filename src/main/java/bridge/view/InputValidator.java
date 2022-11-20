package bridge.view;

import bridge.exception.BridgeException;
import bridge.exception.view.BridgeSizeRangeException;
import bridge.exception.view.MoveInputException;

public class InputValidator {
    private static final int BRIDGE_LENGTH_MIN = 3;
    private static final int BRIDGE_LENGTH_MAX = 20;
    private static final String INPUT_NUMBER_EXCEPTION_MESSAGE = "숫자가 아닙니다.";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String MOVE_REGEX = String.join("|", UP, DOWN);

    public void validateBridgeSizeRange(int size) {
        if (size < BRIDGE_LENGTH_MIN || size > BRIDGE_LENGTH_MAX) {
            throw new BridgeSizeRangeException(BRIDGE_LENGTH_MIN, BRIDGE_LENGTH_MAX);
        }
    }

    public int validateNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException exception) {
            throw new BridgeException(INPUT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public void validateInputMoving(String moving) {
        if (moving == null || !moving.matches(MOVE_REGEX)) {
            throw new MoveInputException(DOWN, UP);
        }
    }
}
