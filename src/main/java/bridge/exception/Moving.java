package bridge.exception;

public class Moving {
    private static final String MOVING_UP = "U";
    private static final String MOVING_DOWN = "D";
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
        return movingInput.length() != 1;
    }

    private boolean checkInvalidMoving() {
        return movingInput.equals(MOVING_UP) || movingInput.equals(MOVING_DOWN);
    }
}
