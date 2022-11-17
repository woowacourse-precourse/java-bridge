package bridge.domain;

import bridge.constant.Constant;
import bridge.constant.ErrorMessage;

public class Moving {
    private final String moving;

    public Moving(String moving) {
        validMoving(moving);
        this.moving = moving;
    }

    private void validMoving(String moving) {
        if (!moving.equals(Constant.UP) && !moving.equals(Constant.DOWN)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MOVING_VALUE.getMessage());
        }
    }

    public boolean isSame(String moving) {
        if (this.moving.equals(moving)) {
            return true;
        }
        return false;
    }
}
