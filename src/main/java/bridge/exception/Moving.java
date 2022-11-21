package bridge.exception;

public class Moving {
    private static final String MOVING_UP = "U";
    private static final String MOVING_DOWN = "D";
    private final String movingInput;

    public Moving(String movingInput) {
        this.movingInput = movingInput;
    }

    private boolean isNotOneCharacter() {
        return movingInput.length() != 1;
    }

    private boolean checkInvalidMoving() {
        return movingInput.equals(MOVING_UP) || movingInput.equals(MOVING_DOWN);
    }
}
