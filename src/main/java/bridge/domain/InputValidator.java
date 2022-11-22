package bridge.domain;

import bridge.Constants;

public class InputValidator {
    public void validateBridgeSize(String input) {
        try {
            isInRange(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputErrorMessage.BRIDGE_NUMBER.message());
        }
    }

    public void isInRange(int bridgeSize) {
        if (bridgeSize < Constants.BRIDGE_SIZE_MIN || bridgeSize > Constants.BRIDGE_SIZE_MAX) {
            throw new IllegalArgumentException(InputErrorMessage.BRIDGE_SIZE.message());
        }
    }

    public void validateMoving(String input) {
        if (!input.equals(Constants.CODE_UP) && !input.equals(Constants.CODE_DOWN)) {
            throw new IllegalArgumentException(InputErrorMessage.MOVING.message());
        }
    }

    public void validateGameCommand(String input) {
        if (!input.equals(Constants.CODE_RETRY) && !input.equals(Constants.CODE_QUIT)) {
            throw new IllegalArgumentException(InputErrorMessage.GAME_COMMAND.message());
        }
    }
}
