package bridge.util;

import bridge.domain.Error;

public class Validation {

    public boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.INPUT_INTEGER_ERROR.getErrorMessage());
        }

        return true;
    }

    public void validateInputBridgeSize(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(Error.BRIDGE_SIZE_ERROR.getErrorMessage());
        }
    }

    public void validateInputMoving(String moving) {
        if (!moving.equals("U") && !moving.equals("D")) {
            throw new IllegalArgumentException(Error.INPUT_MOVING_ERROR.getErrorMessage());
        }
    }

    public void validateInputRetry(String retryCommand) {
        if (!retryCommand.equals("R") && !retryCommand.equals("Q")) {
            throw new IllegalArgumentException(Error.INPUT_RETRY_COMMAND.getErrorMessage());
        }
    }
}
