package bridge.view.validation;

import bridge.vo.ErrorMessage;

public class BridgeLengthValidator {

    private static final String NUMBER_REGEX = "^[0-9]+$";
    private static final int MIN_BRIDGE_LENGTH = 3;
    private static final int MAX_BRIDGE_LENGTH = 20;

    public static void validate(String input) {
        checkNumberFormat(input);
        checkNumberRange(input);
    }

    private static void checkNumberFormat(String input) {
        if (!input.matches(NUMBER_REGEX))
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.BRIDGE_LENGTH_INPUT_ERROR_MESSAGE.toString(),
                            MIN_BRIDGE_LENGTH, MAX_BRIDGE_LENGTH));
    }

    private static void checkNumberRange(String input) {
        try {
            int length = Integer.parseInt(input);
            isInputMinBetweenMax(length);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.BRIDGE_LENGTH_INPUT_ERROR_MESSAGE.toString(),
                            MIN_BRIDGE_LENGTH, MAX_BRIDGE_LENGTH));
        }
    }

    private static void isInputMinBetweenMax(int length) {
        if (length < MIN_BRIDGE_LENGTH || length > MAX_BRIDGE_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.BRIDGE_LENGTH_INPUT_ERROR_MESSAGE.toString(),
                            MIN_BRIDGE_LENGTH, MAX_BRIDGE_LENGTH));
        }
    }
}
