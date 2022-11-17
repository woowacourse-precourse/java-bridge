package bridge.domain;

import java.util.List;

import static bridge.utils.ErrorMessages.ERROR_INVALID_MOVING;

public class BridgeMoving {
    private final String moving;

    public BridgeMoving(String moving) {
        validateMoving(moving);
        this.moving = moving;
    }

    private void validateMoving(String moving) {
        if (!(moving.equals("U") || moving.equals("D"))) {
            throw new IllegalArgumentException(ERROR_INVALID_MOVING);
        }
    }
}
