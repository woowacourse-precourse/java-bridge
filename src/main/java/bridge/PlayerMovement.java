package bridge;

public class PlayerMovement {
    private static final String UPPER_CHECK = "U";
    private static final String LOWER_CHECK = "D";

    public void addMovement(String move) {
        validate(move);
    }

    private void validate(String move) {
        if (!move.equals(UPPER_CHECK) && !move.equals(LOWER_CHECK)) {
            ExceptionMessage.INPUT_WRONG_BRIDGE_MOVEMENT_MESSAGE.throwException();
        }
    }
}
