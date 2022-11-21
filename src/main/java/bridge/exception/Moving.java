package bridge.exception;

public class Moving {
    private final String movingInput;

    public Moving(String movingInput) {
        this.movingInput = movingInput;
    }

    private boolean isNotOneCharacter() {
        return movingInput.length() != 1;
    }
}
