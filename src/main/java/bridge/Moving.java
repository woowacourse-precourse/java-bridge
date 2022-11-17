package bridge;

public class Moving {
    private static final String MOVE_TO_UP = "U";
    private static final String MOVE_TO_DOWN = "D";

    private final String moving;

    public Moving(String move) {
        validate(move);
        this.moving = move;
    }

    private void validate(String move) {
        if (!isValidSpaceToMove(move)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidSpaceToMove(String move) {
        return move.equals(MOVE_TO_UP) || move.equals(MOVE_TO_DOWN);
    }
}
