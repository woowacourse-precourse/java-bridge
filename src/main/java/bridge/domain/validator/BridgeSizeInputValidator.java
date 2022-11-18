package bridge.domain.validator;

import bridge.util.Errors;

public class BridgeSizeInputValidator implements Validator {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    @Override
    public void validate(String inputValue) {
        try{
            validateIsBlank(inputValue);
            inputValue = inputValue.trim();
            validateIsInvalid(inputValue);
            validateRange(inputValue);
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
        if (!inputValue.matches("\\d{1,2}")) {
            throw new IllegalArgumentException(Errors.NOT_NUMBER.message());
        }

    }

    public void validateRange(String inputValue) {
        int inputValueToInt = Integer.parseInt(inputValue.trim());
        if (inputValueToInt < MIN_SIZE || inputValueToInt > MAX_SIZE){
            throw new IllegalArgumentException(Errors.OUT_OF_BOUND.message());
        }
    }
}
