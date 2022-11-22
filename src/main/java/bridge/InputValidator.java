package bridge;

import bridge.constant.BridgeMoveCommand;
import bridge.constant.BridgeRetryCommand;
import bridge.constant.InputValidationError;

public class InputValidator {
    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;

    public InputValidator() {

    }

    public void validateBridgeSize(int size) throws IllegalArgumentException {
        if (size < MINIMUM_BRIDGE_SIZE || size > MAXIMUM_BRIDGE_SIZE) {
            throw InputValidationError.ERROR_BRIDGE_SIZE.exception;
        }
    }

    public int validateBridgeSizeParsable(String size) throws IllegalArgumentException {
        int parsedSize;
        try {
            parsedSize = Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw InputValidationError.ERROR_BRIDGE_SIZE.exception;
        }
        return parsedSize;
    }

    public void validateMove(String cmd) throws IllegalArgumentException {
        BridgeMoveCommand.getByCommand(cmd);
    }

    public void validateGameCommand(String cmd) throws IllegalArgumentException {
        BridgeRetryCommand.getByCommand(cmd);
    }
}
