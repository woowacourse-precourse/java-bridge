package bridge.exception;

import bridge.enums.ErrorMessage;
import bridge.enums.KeyboardCommand;

public class InputException {
    private final int MINIMUM_BRIDGE_LENGTH = 3;
    private final int MAXIMUM_BRIDGE_LENGTH = 20;

    public void validateBridgeSize(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER.getMessage());
        }
        if (Integer.parseInt(bridgeSize) < MINIMUM_BRIDGE_LENGTH
                || Integer.parseInt(bridgeSize) > MAXIMUM_BRIDGE_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }

    public void validateMoving(String moving) {
        if (!moving.equals(KeyboardCommand.UP.getCommand())
                && !moving.equals(KeyboardCommand.DOWN.getCommand())) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_OPTIONS.getMessage());
        }
    }

    public void validateGameCommand(String gameCommand) {
        if (!gameCommand.equals(KeyboardCommand.RESTART.getCommand())
                && !gameCommand.equals(KeyboardCommand.QUIT.getCommand())) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_OPTIONS.getMessage());
        }
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
