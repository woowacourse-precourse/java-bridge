package bridge.domain.vo;

import bridge.domain.enumeration.MovingType;

import static bridge.domain.enumeration.ErrorMessage.*;
import static bridge.domain.enumeration.MovingType.*;

public class Moving {

    private final String moving;
    private final int MOVING_MAX_LENGTH = 1;

    public static Moving createMoving(String moving) {
        return new Moving(moving);
    }

    public Moving(String moving) {
        validateMoving(moving);
        this.moving = moving;
    }

    public String getMoving() {
        return this.moving;
    }

    private void validateMoving(String moving) {
        if (moving.length() != MOVING_MAX_LENGTH) {
            throw new IllegalArgumentException(MOVING_LENGTH_IS_NOT_ONE.getErrorMessage());
        }
        if (!moving.equals(UP.getMovingType()) && !moving.equals(DOWN.getMovingType())) {
            throw new IllegalArgumentException(MOVING_IS_NOT_U_AND_D.getErrorMessage());
        }
    }
}
