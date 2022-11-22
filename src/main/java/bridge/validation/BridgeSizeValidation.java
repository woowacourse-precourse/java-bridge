package bridge.validation;

import bridge.util.message.ErrorMessage;

public class BridgeSizeValidation implements Validation {
    private static final int START = 3;
    private static final int END = 20;
    private static final String VALID_NUMBER = "[0-9]*$";

    @Override
    public void validate(String value) {
        isNumber(value);
        isNotInRange(Integer.parseInt(value));
    }

    private void isNumber(String number) {
        if (!number.matches(VALID_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_BRIDGE_SIZE.getMessage());
        }
    }

    private void isNotInRange(int number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE_BRIDGE_SIZE.getMessage());
        }
    }

    private static boolean isInRange(int number) {
        return (number >= START && number <= END);
    }
}
