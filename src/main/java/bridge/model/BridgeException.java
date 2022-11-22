package bridge.model;

import bridge.view.ErrorView;
import bridge.view.MessageView;

public class BridgeException {

    public boolean invalidLengthInputValue(String bridgeLength) {
        if (invalidFormat(bridgeLength)) {
                throw new IllegalArgumentException(ErrorView.error + ErrorView.INVALID_BRIDGE_LENGTH.getMessage());
            } else if (outOfRange(Integer.parseInt(bridgeLength))) {
                throw new IllegalArgumentException(ErrorView.error + ErrorView.INVALID_BRIDGE_LENGTH.getMessage());
            }
        return false;
    }

    private boolean invalidFormat(String bridgeLength) {
        try {
            Integer.parseInt(bridgeLength);
        } catch (NumberFormatException e) {
            return true;
        } return false;
    }

    private boolean outOfRange(int bridgeLength) {
        return bridgeLength < 3 || bridgeLength > 20;
    }

    public boolean invalidMovingInputValue(String moveDirection) {
        if (!moveDirection.equals(MessageView.UP.getMessage()) && !moveDirection.equals(MessageView.DOWN.getMessage())) {
                throw new IllegalArgumentException(ErrorView.error + ErrorView.INVALID_MOVING_DIRECTION.getMessage());
            }
        return false;
    }

    public boolean invalidRetryGame(String retryGame) {
        if (!retryGame.equals(MessageView.RETURN_RETRY.getMessage()) && !retryGame.equals(MessageView.RETURN_QUIT.getMessage())) {
                throw new IllegalArgumentException(ErrorView.error + ErrorView.INVALID_RETRY_GAME.getMessage());
            }
        return false;
    }
}
