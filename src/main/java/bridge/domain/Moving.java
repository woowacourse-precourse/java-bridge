package bridge.domain;

import bridge.constant.Constant;
import bridge.constant.ErrorMessage;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(moving);
    }

    @Override
    public boolean equals(Object obj) {
        if (moving.equals(obj)) {
            return true;
        }
        return false;
    }
}
