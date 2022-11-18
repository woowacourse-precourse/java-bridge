package bridge.domain.validator;

import bridge.util.Errors;

public class ContinueInputValidator implements Validator {

    private static final String CONTINUE_VALUE = "R";
    private static final String QUIT_VALUE = "Q";

    @Override
    public void validate(String inputValue) {
        try {
            validateIsBlank(inputValue);
            inputValue = inputValue.trim();
            validateIsInvalid(inputValue);
            validateIsUpperCase(inputValue);
        }catch (IllegalArgumentException exception){
            throw exception ;
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
        if (!inputValue.matches("[rRqQ]")) {
            throw new IllegalArgumentException(Errors.INVALID_CONTINUE_VALUE.message());
        }
    }

    public void validateIsUpperCase(String inputValue) {
        if (inputValue.equals(CONTINUE_VALUE.toLowerCase()) || inputValue.equals(QUIT_VALUE.toLowerCase())) {
            throw new IllegalArgumentException(Errors.NOT_UPPERCASE.message());
        }

    }
}
