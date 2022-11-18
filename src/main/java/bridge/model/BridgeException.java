package bridge.model;

import bridge.view.ErrorView;

public class BridgeException {

    public void invalidLengthInputValue(String bridgeLength) {
        if (invalidFormat(bridgeLength)) {
            throw new IllegalArgumentException(ErrorView.error + ErrorView.INVALID_BRIDGE_LENGTH.getMessage());
        }
        if (outOfRange(Integer.parseInt(bridgeLength))) {
            throw new IllegalArgumentException(ErrorView.error + ErrorView.INVALID_BRIDGE_LENGTH.getMessage());
        }
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

    public void invalidMovingInputValue(String moveDirection) {
        if (!moveDirection.equals("U") && !moveDirection.equals("D")) {
            throw new IllegalArgumentException(ErrorView.error + ErrorView.INVALID_MOVING_DIRECTION.getMessage());
        }
    }

    public void invalidRetryGame(String retryGame) {
        if (!retryGame.equals("R") && !retryGame.equals("Q")) {
            throw new IllegalArgumentException(ErrorView.error + ErrorView.INVALID_RETRY_GAME.getMessage());
        }
    }
}
