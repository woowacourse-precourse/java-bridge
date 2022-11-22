package bridge.model;

import bridge.constant.ExceptionMessage;
import bridge.constant.Moving;

public class BridgeMoving {

    private final String moving;

    private BridgeMoving(String moving) {
        validateBridgeMoving(moving);
        this.moving = moving;
    }

    public String getMoving() {
        return moving;
    }

    public static BridgeMoving createBridgeMoving(String moving) {
        return new BridgeMoving(moving);
    }

    public void validateBridgeMoving(String moving) {
        if (isMovingFormatCorrect(moving)) {
            return;
        }
        throw new IllegalArgumentException(ExceptionMessage.MOVING_NON_FORMAT_ERROR_MESSAGE.getMessage());
    }

    private static boolean isMovingFormatCorrect(String moving) {
        return moving.equals(Moving.DOWN.getDescription()) || moving.equals(Moving.UP.getDescription());
    }

}
