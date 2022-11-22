package bridge.view;

import static bridge.Constants.MoveMark.*;
import static bridge.Constants.CommandMark.*;
import static bridge.Constants.*;

public class Validator {
    final int MIN_BRIDGE_SIZE = 3;
    final int MAX_BRIDGE_SIZE = 20;

    public void validateBridgeSize(String input) {
        int bridgeSize = strToInt(input);
        isBetweenRange(bridgeSize);
    }

    public void validateMoving(String input) {
        if (!input.equals(DOWN.mark()) && !input.equals(UP.mark())) {
            throw new IllegalArgumentException(IS_NOT_PROPER_MOVING);
        }
    }

    public void validateGameCommand(String input) {
        if (!input.equals(RETRY.mark()) && !input.equals(QUIT.mark())) {
            throw new IllegalArgumentException(IS_NOT_PROPER_COMMAND);
        }
    }

    private int strToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMBER);
        }
    }

    private void isBetweenRange(int input) {
        if (input < MIN_BRIDGE_SIZE || input > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(IS_NOT_IN_RANGE);
        }
    }
}
