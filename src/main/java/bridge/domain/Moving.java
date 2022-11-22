package bridge.domain;

import bridge.exception.BridgeError;
import bridge.exception.ErrorException;
import bridge.utils.Constants;
import bridge.utils.Direction;

public class Moving {
    private final String movingInput;

    public Moving(String movingInput) {
        this.movingInput = movingInput;
        validMovingHandler();
    }

    private void validMovingHandler() {
        if (isNotOneCharacter()) {
            throw new ErrorException(BridgeError.IS_NOT_ONE_CHARACTER);
        }
        if (!checkInvalidMoving()) {
            throw new ErrorException(BridgeError.INVALID_DIRECTION);
        }
    }

    private boolean isNotOneCharacter() {
        return movingInput.length() != Constants.MOVING_INPUT_SIZE;
    }

    private boolean checkInvalidMoving() {
        String up = Direction.MOVING_UP.getMovingDirection();
        String down = Direction.MOVING_DOWN.getMovingDirection();

        return movingInput.equals(up) || movingInput.equals(down);
    }
}
