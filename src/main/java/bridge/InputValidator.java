package bridge;

import bridge.constant.InputValidationError;

public class InputValidator {
    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;

    public InputValidator() {

    }

    public void validateBridgeSize(int size) throws IllegalArgumentException {
        if(size < MINIMUM_BRIDGE_SIZE || size > MAXIMUM_BRIDGE_SIZE){
            throw InputValidationError.ERROR_BRIDGE_SIZE.exception;
        }
    }

    public void validateMove() throws IllegalArgumentException {

    }

    public void validateGameCommand() throws IllegalArgumentException {

    }
}
