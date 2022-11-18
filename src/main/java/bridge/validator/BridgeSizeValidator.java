package bridge.validator;

import bridge.resource.message.ErrorMessage;

public class BridgeSizeValidator implements Validator {
    @Override
    public void validate(String inputValue) {
        if (isNonNumericValue(inputValue)) {
            System.out.println(ErrorMessage.NON_NUMERIC_VALUE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private boolean isNonNumericValue(String inputValue) {
        return !inputValue.chars().allMatch(Character::isDigit);
    }
}
