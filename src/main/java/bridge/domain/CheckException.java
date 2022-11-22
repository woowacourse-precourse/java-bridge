package bridge.domain;

import bridge.view.ErrorMessage;

public class CheckException {
    private final int MAX_BRIDGE_SIZE = 20;
    private final int MIN_BRIDGE_SIZE = 3;

    public boolean checkBridgeSize(String bridgeSize) {
        try {
            if (Integer.parseInt(bridgeSize) > MAX_BRIDGE_SIZE || Integer.parseInt(bridgeSize) < MIN_BRIDGE_SIZE) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.ERROR_MESSAGE_SIZE_OUT_OF_RANGE.getMessage());
            return false;
        }
    }

    public boolean checkInputMoving(String moving) {
        try {
            if (!moving.equals("U") && !moving.equals("D")) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.ERROR_MESSAGE_INPUT_MOVING_NOT_VALID.getMessage());
            return false;
        }
    }

    public boolean checkInputRetryChoice(String retryChoice) {
        try {
            if (!retryChoice.equals("R") && !retryChoice.equals("Q")) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.ERROR_MESSAGE_INPUT_RETRY_CHOICE_NOT_VALID.getMessage());
            return false;
        }
    }
}
