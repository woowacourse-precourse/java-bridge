package bridge.domain.validator;

import bridge.util.Errors;

public class MovingInputValidator implements Validator {

    private static final String MOVE_UP_VALUE = "U";
    private static final String MOVE_DOWN_VALUE = "D";

    @Override
    public void validate(String inputValue) {
        try{
            validateIsBlank(inputValue);
            inputValue = inputValue.trim();
            validateIsInvalid(inputValue);
            validateIsUpperCase(inputValue);
        }catch (IllegalArgumentException exception){
            throw exception;
        }
    }

    @Override
    public void validateIsBlank(String inputValue) {
        if (inputValue.isBlank()) {
            throw new IllegalArgumentException(Errors.IS_EMPTY.message());
        }
    }

    @Override
    public void validateIsInvalid(String inputValue) {
        if (!inputValue.matches("[uUdD]")) {
            throw new IllegalArgumentException(Errors.INVALID_MOVE_VALUE.message());
        }
    }

    public void validateIsUpperCase(String inputValue) {
        if (inputValue.equals(MOVE_UP_VALUE.toLowerCase()) || inputValue.equals(MOVE_DOWN_VALUE.toLowerCase())) {
            throw new IllegalArgumentException(Errors.NOT_UPPERCASE.message());
        }
    }
}
