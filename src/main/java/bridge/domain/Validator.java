package bridge.domain;

import java.util.List;


import static bridge.util.ExceptionMessage.INVALID_CHARACTER;
import static bridge.util.ExceptionMessage.NOT_NUMERIC;
import static bridge.util.ExceptionMessage.NULL;
import static bridge.util.ExceptionMessage.OUT_OF_RANGE;

public class Validator {

    public int validateNumericInput(String input) {
        validateNull(input);

        return validateRange(validateNumber(input));
    }

    public String validateCharacterInput(String input, List<String> indicators) {
        validateNull(input);
        validateCharacter(input, indicators);

        return input;
    }

    private void validateNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(NULL.of());
        }
    }

    private void validateCharacter(String input, List<String> indicators) {
        if (!indicators.contains(input)) {
            throw new IllegalArgumentException(INVALID_CHARACTER.of());
        }
    }

    private int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC.of());
        }
    }

    private int validateRange(int input) {
        int MINIMUM_VALUE = 3;
        int MAXIMUM_VALUE = 20;
        if (input < MINIMUM_VALUE || MAXIMUM_VALUE < input) {
            throw new IllegalArgumentException(OUT_OF_RANGE.of(MINIMUM_VALUE, MAXIMUM_VALUE));
        }
        return input;
    }
}
