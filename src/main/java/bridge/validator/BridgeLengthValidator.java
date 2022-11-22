package bridge.validator;

import bridge.constants.ValidatorMessage;

public class BridgeLengthValidator {

    private static final int MIN_RANGE = 3;
    private static final int MAX_RANGE = 20;

    public static void validateNaturalNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidatorMessage.BRIDGE_LENGTH_MESSAGE.toString());
        }
    }

    public static void validateRange(String input) {
        if (Integer.parseInt(input) < MIN_RANGE || Integer.parseInt(input) > MAX_RANGE) {
            throw new IllegalArgumentException(ValidatorMessage.BRIDGE_LENGTH_MESSAGE.toString());
        }
    }
}
