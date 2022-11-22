package bridge.controller.request;

public class MoveRequest {

    private static final String MOVE_UP = "U";
    private static final String MOVE_DOWN = "D";

    private final String move;

    public MoveRequest(String move) {
        validate(move);
        this.move = move;
    }

    private void validate(String move) {
        if (!isValid(move)) {
            throw new IllegalArgumentException("이동시 입력값은 U, D 만 가능합니다.");
        }
    }

    private boolean isValid(String move) {
        return move.equals(MOVE_UP) || move.equals(MOVE_DOWN);
    }

    public String getMove() {
        return move;
    }
}
