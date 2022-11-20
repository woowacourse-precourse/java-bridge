package bridge.view;

import bridge.exception.BridgeException;
import bridge.exception.view.BridgeSizeRangeException;

public class InputValidator {
    private static final int BRIDGE_LENGTH_MIN = 3;
    private static final int BRIDGE_LENGTH_MAX = 20;
    private static final String INPUT_NUMBER_EXCEPTION_MESSAGE = "숫자가 아닙니다.";

    public void validateBridgeSizeRange(int size) {
        if (size < BRIDGE_LENGTH_MIN || size > BRIDGE_LENGTH_MAX) {
            throw new BridgeSizeRangeException(BRIDGE_LENGTH_MIN, BRIDGE_LENGTH_MAX);
        }
    }

    public int inputNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException exception) {
            throw new BridgeException(INPUT_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
