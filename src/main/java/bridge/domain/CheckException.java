package bridge.domain;

import bridge.view.ErrorMessage;

public class CheckException {

    public boolean checkBridgeSize(String bridgeSize) {
        try {
            if (Integer.parseInt(bridgeSize) > 20 || Integer.parseInt(bridgeSize) < 3) {
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
