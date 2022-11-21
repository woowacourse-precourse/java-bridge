package bridge.constant;

import static bridge.constant.ErrorResponse.INVALID_INPUT_MOVING_DIRECTION;

public enum MovingDirection {
    U("U"), D("D");

    private final String direction;

    MovingDirection(String direction) {
        this.direction = direction;
    }

    public static MovingDirection from(String inputMovingDirection) {
        for (MovingDirection direction : MovingDirection.values()) {
            if (isSameDirection(inputMovingDirection, direction)) {
                return direction;
            }
        }
        throw INVALID_INPUT_MOVING_DIRECTION.getValue();
    }

    private static boolean isSameDirection(String inputMovingDirection, MovingDirection direction) {
        return direction.name().equals(inputMovingDirection);
    }

    public String getValue() {
        return this.direction;
    }
}
