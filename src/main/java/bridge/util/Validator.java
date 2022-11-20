package bridge.util;

import static bridge.model.Command.*;
import static bridge.model.Direction.*;
import static bridge.message.ErrorMessage.*;

public class Validator {
    private static final int BRIDGE_MIN_LENGTH = 1;
    private static final int BRIDGE_MAX_LENGTH = 2;
    private static final int BRIDGE_MIN_BOUNDARY = 3;
    private static final int BRIDGE_MAX_BOUNDARY = 20;

    public void validateBridgeSize(String input) {
        validateBridgeLength(input);
        validateBridgeDigit(input);
        validateBridgeRange(input);
    }

    private void validateBridgeLength(String input) {
        if (input.length() < BRIDGE_MIN_LENGTH || input.length() > BRIDGE_MAX_LENGTH) {
            throw new IllegalArgumentException(INCORRECT_BRIDGE_SIZE);
        }
    }

    private void validateBridgeDigit(String input) {
        if (!isDigit(input)) {
            throw new IllegalArgumentException(INCORRECT_BRIDGE_SIZE);
        }
    }

    private boolean isDigit(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    private void validateBridgeRange(String input) {
        int i = Integer.parseInt(input);
        if (i < BRIDGE_MIN_BOUNDARY || i > BRIDGE_MAX_BOUNDARY) {
            throw new IllegalArgumentException(INCORRECT_BRIDGE_SIZE);
        }
    }

    public void validateMoving(String input) {
        if (!isDirection(input)){
            throw new IllegalArgumentException(INCORRECT_MOVING);
        }
    }

    public void validateGameCommand(String input) {
        if (!isGameCommand(input)) {
            throw new IllegalArgumentException(INCORRECT_GAME_COMMAND);
        }
    }

    private boolean isGameCommand(String input) {
        return input.equals(RETRY.getName()) || input.equals(END.getName());
    }
}
