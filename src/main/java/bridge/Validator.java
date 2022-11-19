package bridge;

import static bridge.ErrorMessage.INCORRECT_BRIDGE_SIZE;

public class Validator {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 2;
    private static final int MIN_BOUNDARY = 3;
    private static final int MAX_BOUNDARY = 20;

    public void validateBridgeSize(String input) {
        validateBridgeLength(input);
        validateBridgeDigit(input);
        validateBridgeRange(input);
    }

    private void validateBridgeLength(String input) {
        if (input.length() < MIN_LENGTH || input.length() > MAX_LENGTH) {
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
        if (i < MIN_BOUNDARY || i > MAX_BOUNDARY) {
            throw new IllegalArgumentException(INCORRECT_BRIDGE_SIZE);
        }
    }
}
