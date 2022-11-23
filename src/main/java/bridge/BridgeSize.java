package bridge;

import bridge.constant.ErrorMessage;

public class BridgeSize {

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    private final int size;

    public BridgeSize(String size) {
        validate(size);

        this.size = toInteger(size);
    }

    public static BridgeSize of (String size) {
        return new BridgeSize(size);
    }

    private void validate(String size) {
        validateNonBlank(size);
        validateNumeric(size);
        validateRange(toInteger(size));
    }

    private void validateNonBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BLANK_INPUT);
        }
    }

    private void validateNumeric(String input) {
        if (isNonNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC_INPUT);
        }
    }

    private boolean isNonNumeric(String input) {
        return !input.chars().allMatch(Character::isDigit);
    }

    private static void validateRange(int size) {
        if (isInvalidRange(size)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_SIZE_RANGE);
        }
    }

    private static boolean isInvalidRange(int size) {
        return size < MIN_SIZE || size > MAX_SIZE;
    }

    private int toInteger(String size) {
        return Integer.parseInt(size);
    }

    public int getSize() {
        return size;
    }
}
