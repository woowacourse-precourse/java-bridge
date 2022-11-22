package bridge.domain.value;

import static bridge.utils.ErrorMessages.ERROR_INVALID_MOVING;

public class MovingShape {
    private static final String UP_SIDE_MOVING = "U";
    private static final String DOWN_SIDE_MOVING = "D";
    private final String shape;

    public MovingShape(String shape) {
        validate(shape);
        this.shape = shape;
    }

    public void validate(String moving) {
        validateMoving(moving);
    }

    private void validateMoving(String moving) {
        if (!(moving.equals(UP_SIDE_MOVING) || moving.equals(DOWN_SIDE_MOVING))) {
            throw new IllegalArgumentException(ERROR_INVALID_MOVING);
        }
    }

    public boolean isEqual(String shape) {
        return this.shape.equals(shape);
    }

    public String getShape() {
        return shape;
    }
}
