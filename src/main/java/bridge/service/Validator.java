package bridge.service;

import bridge.constants.ErrorMessage;
import bridge.constants.ValidatorElement;

public class Validator {
    private final ErrorMessage errorMessage = new ErrorMessage();
    private final ValidatorElement validatorElement = new ValidatorElement();

    public void validateBridgeSize(int input) {
        if(!(validatorElement.MIN_NUMBER <= input && input <= validatorElement.MAX_NUMBER)) {
            throw new IllegalArgumentException(errorMessage.NOT_BRIDGE_LENGTH_RANGE);
        }
    }
    public void validateDirection(String input) {
        if(!(input.equals(validatorElement.UP) || input.equals(validatorElement.DOWN))) {
            throw new IllegalArgumentException(errorMessage.NOT_INPUT_U_OR_D);
        }
    }

    public void validateRetryOfQuit(String input) {
        if(!(input.equals(validatorElement.RETRY) || input.equals(validatorElement.QUIT))) {
            throw new IllegalArgumentException(errorMessage.NOT_INPUT_R_OR_Q);
        }
    }
}
