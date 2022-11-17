package bridge.model;

import bridge.view.ErrorView;

public class BridgeException {

    public void invalidMovingInputValue(String moveDirection) {
        if (moveDirection != "U" || moveDirection != "D") {
            throw new IllegalArgumentException(ErrorView.error + ErrorView.INVALID_MOVING_DIRECTION.getMessage());
        }
    }

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
}
