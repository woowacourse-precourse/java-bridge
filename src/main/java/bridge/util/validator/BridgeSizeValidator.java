package bridge.util.validator;

import bridge.util.ExceptionMessage;
import java.util.regex.Pattern;

public class BridgeSizeValidator extends Validator {
    private enum Range {
        MIN_RANGE(3), MAX_RANGE(20);

        private final int value;

        Range(int value) {
            this.value = value;
        }
    }

    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");

    @Override
    public void validate(String input) throws IllegalArgumentException {
        String bridgeSize = removeSpace(input);
        validateNumber(bridgeSize);
        validateInputRange(bridgeSize);
        validateNumberRange(bridgeSize);
    }

    private void validateNumber(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }
    }

    private void validateInputRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_INT_RANGE.getMessage());
        }
    }

    private void validateNumberRange(String input) {
        int number = Integer.parseInt(input);
        if (number < Range.MIN_RANGE.value || number > Range.MAX_RANGE.value) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_IN_RANGE.getMessage());
        }
    }
}
