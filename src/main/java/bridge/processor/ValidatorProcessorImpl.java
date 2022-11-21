package bridge.processor;

import bridge.enummodel.CommandEnum;
import bridge.enummodel.ErrorMessageEnum;

public class ValidatorProcessorImpl implements ValidatorProcessor{
    private static final int MIN_SIZE_NUMBER = 3;
    private static final int MAX_SIZE_NUMBER = 20;

    @Override
    public Integer validateBridgeSizeInput(String input) {
        int inputInt = Integer.parseInt(input);
        if (inputInt < MIN_SIZE_NUMBER || inputInt > MAX_SIZE_NUMBER) {
            throw new IllegalArgumentException(ErrorMessageEnum.NOT_VALIDATE_SIZE.getValue());
        }
        return inputInt;
    }

    @Override
    public void validateRetryInput(String input) {
        if (!CommandEnum.RESTART.getValue().equals(input) &&
                !CommandEnum.QUIT.getValue().equals(input)) {
            throw new IllegalArgumentException(ErrorMessageEnum.NOT_VALIDATE.getValue());
        }
    }

    @Override
    public void validateCommandInput(String input) {
        if (!CommandEnum.UP.getValue().equals(input) &&
                !CommandEnum.DOWN.getValue().equals(input)) {
            throw new IllegalArgumentException(ErrorMessageEnum.NOT_VALIDATE.getValue());
        }
    }
}
