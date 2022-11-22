package bridge.constant;

import static bridge.constant.ErrorResponse.INVALID_INPUT_MOVING_DIRECTION;
import static bridge.constant.ErrorResponse.NOT_FOUND_DIRECTION;

public enum MovingDirection {
    U("U", "1"), D("D", "0");

    private final String direction;
    private final String directionNumber;

    MovingDirection(String direction, String directionNumber) {
        this.direction = direction;
        this.directionNumber = directionNumber;
    }

    public static MovingDirection from(String inputMovingDirection) {
        for (MovingDirection direction : MovingDirection.values()) {
            if (isSameDirection(inputMovingDirection, direction)) {
                return direction;
            }
        }
        throw INVALID_INPUT_MOVING_DIRECTION.getException();
    }

    private static boolean isSameDirection(String inputMovingDirection,
        MovingDirection movingDirection) {
        return movingDirection.direction.equals(inputMovingDirection)
            || movingDirection.directionNumber.equals(inputMovingDirection);
    }

    public static String getDirection(int directionNumber) {
        for (MovingDirection movingDirection : MovingDirection.values()) {
            if (isSameDirectionNUmber(directionNumber, movingDirection)) {
                return movingDirection.direction;
            }
        }
        throw NOT_FOUND_DIRECTION.getException();
    }

    private static boolean isSameDirectionNUmber(int directionNumber,
        MovingDirection movingDirection) {
        return movingDirection.directionNumber.equals(String.valueOf(directionNumber));
    }
}
