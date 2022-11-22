package bridge.model.validator;

import bridge.model.constant.BridgeStatistic;

import java.util.regex.Pattern;

public class BridgeSizeValidator implements Validator {
    private static final String bridgeSizePattern = "^[0-9]*$";

    @Override
    public void validateInput(String input) {
        validateNumeric(input);
        validateLength(input);
        int inputNumber = Integer.parseInt(input);
        validateRange(inputNumber);
    }

    public void validateNumeric(String input) {
        if (input == null || input.isEmpty() || !Pattern.matches(bridgeSizePattern, input)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateLength(String input) {
        int upperBound = BridgeStatistic.UPPER_BOUND.getValue();
        if (input.length() > Integer.toString(upperBound).length()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateRange(int inputNumber) {
        if (inputNumber < BridgeStatistic.LOWER_BOUND.getValue()
                || inputNumber > BridgeStatistic.UPPER_BOUND.getValue()) {
            throw new IllegalArgumentException();
        }
    }
}
