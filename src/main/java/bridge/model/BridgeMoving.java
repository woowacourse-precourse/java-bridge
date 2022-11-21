package bridge.model;

public class BridgeMoving {

    private final String moving;

    public BridgeMoving(String moving) {
        validateBridgeMoving(moving);
        this.moving = moving;
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
