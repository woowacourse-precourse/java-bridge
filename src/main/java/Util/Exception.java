package Util;

public class Exception {

    public void throwIllegalArgumentExceptionError(String message) throws IllegalArgumentException {
        throw new IllegalArgumentException(message);
    }

    public void validateInputNumberRange(String inputNumber) throws IllegalArgumentException {
        if (Integer.parseInt(inputNumber)<3||Integer.parseInt(inputNumber)>20) {
            throwIllegalArgumentExceptionError(ExceptionMessage.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }

    public void validateIfInputIsNumber(String inputNumber) throws IllegalArgumentException {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throwIllegalArgumentExceptionError(ExceptionMessage.UNEXPECTED_INPUT_MESSAGE.getMessage());
        }
    }

    public void validateMovingInput(String moving) throws IllegalArgumentException {
        if(!(moving.equals("U")||moving.equals("D"))) {
            throwIllegalArgumentExceptionError(ExceptionMessage.UNEXPECTED_INPUT_MESSAGE.getMessage());
        }
    }

    public void validateRetryInput(String gameCommand) throws IllegalArgumentException {
        if(!(gameCommand.equals("R")||gameCommand.equals("Q"))) {
            throwIllegalArgumentExceptionError(ExceptionMessage.UNEXPECTED_INPUT_MESSAGE.getMessage());
        }
    }
}
