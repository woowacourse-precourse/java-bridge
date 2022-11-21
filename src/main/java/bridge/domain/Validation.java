package bridge.domain;

public class Validation {
    private static final String MOVE_UP = "U";
    private static final String MOVE_DOWN = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";


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
        if (!moving.equals(MOVE_UP) && !moving.equals(MOVE_DOWN)) {
            throw new IllegalArgumentException(Error.INPUT_MOVING_ERROR.getErrorMessage());
        }
    }

    public void validateInputRetry(String retryCommand) {
        if (!retryCommand.equals(RETRY) && !retryCommand.equals(QUIT)) {
            throw new IllegalArgumentException(Error.INPUT_RETRY_COMMAND.getErrorMessage());
        }
    }
}
