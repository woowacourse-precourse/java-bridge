package bridge;

public class Exception {

    public void throwIllegalArgumentError(String message) throws IllegalArgumentException {
        throw new IllegalArgumentException(message);
    }

    public void validateInputNumberRange(String inputNumber) throws IllegalArgumentException {
        if (Integer.parseInt(inputNumber)<3||Integer.parseInt(inputNumber)>20) {
            throwIllegalArgumentError(ExceptionMessage.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }

    public void validateIfInputIsNumber(String inputNumber) throws IllegalArgumentException {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throwIllegalArgumentError(ExceptionMessage.UNEXPECTED_INPUT_MESSAGE.getMessage());
        }
    }

    public void validateMovingInput(String moving) {
        if(!(moving.equals("U")||moving.equals("D"))) {
            throwIllegalArgumentError(ExceptionMessage.UNEXPECTED_INPUT_MESSAGE.getMessage());
        }
    }

    public void validateRetryInput(String gameCommand) {
        if(!(gameCommand.equals("R")||gameCommand.equals("Q"))) {
            throwIllegalArgumentError(ExceptionMessage.UNEXPECTED_INPUT_MESSAGE.getMessage());
        }
    }
}
