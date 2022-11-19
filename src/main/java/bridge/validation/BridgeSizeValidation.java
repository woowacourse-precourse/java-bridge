package bridge.validation;

import bridge.Message.ErrorMessage;

public class BridgeSizeValidation implements Validation {
    private static final int start = 3;
    private static final int end = 20;
    private static final String validNumber = "[0-9]*$";

    @Override
    public void validate(String value) {
        isNumber(value);
        isNotInRange(Integer.parseInt(value));
    }

    private void isNumber(String number) {
        if (!number.matches(validNumber)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_BRIDGE_SIZE.getMessage());
        }
    }

    private void isNotInRange(int number) {
        if(!isInRange(number)){
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE_BRIDGE_SIZE.getMessage());
        }
    }

    private static boolean isInRange(int number){
        return (number >= start && number <= end);
    }
}
