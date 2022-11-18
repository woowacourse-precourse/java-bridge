package bridge.validator;

import bridge.utils.message.ErrorMessage;

public class BridgeSizeValidator implements Validator {
    @Override
    public void validate(String inputValue) {
        if (isNonNumericValue(inputValue)) {
            System.out.println(ErrorMessage.NON_NUMERIC_VALUE.getMessage());
            throw new IllegalArgumentException();
        }
        if (inputValue.isBlank()) {
            System.out.println(ErrorMessage.BLANK_VALUE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private boolean isNonNumericValue(String inputValue) {
        return !inputValue.chars().allMatch(Character::isDigit);
    }
}
