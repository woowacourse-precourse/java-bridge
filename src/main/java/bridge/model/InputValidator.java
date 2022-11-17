package bridge.model;

import bridge.view.ErrorMessage;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String bridgeSizePattern = "^[0-9]*$";

    public InputValidator() {
    }

    public static void validateBridgeSize(String input) {
        InputValidator.validateNumeric(input);
        InputValidator.validateLength(input);
        int inputNumber = Integer.parseInt(input);
        InputValidator.validateRange(inputNumber);
    }

    public static void validateNumeric(String input) {
        if (input == null || input.isEmpty() || !Pattern.matches(bridgeSizePattern, input)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateLength(String input) {
        if (input.length() > BridgeSizeConstant.INPUT_LENGTH.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRange(int inputNumber) {
        if (inputNumber < BridgeSizeConstant.LOWER_BOUND.getValue()
                || inputNumber > BridgeSizeConstant.UPPER_BOUND.getValue()) {
            throw new IllegalArgumentException();
        }
    }
}
