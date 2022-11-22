package bridge.model;

public class Moving {
    private final String moving;

    public Moving(String move) {
        validate(move);
        this.moving = move;
    }

    public String getMoving() {
        return moving;
    }

    private void validate(String move) {
        if (!isValidSpaceToMove(move)) {
            throw new IllegalArgumentException("이동할 칸은 U 또는 D 문자 중 하나여야 합니다.");
        }
    }

    private boolean isValidSpaceToMove(String move) {
        return move.equals(Move.U.toString()) || move.equals(Move.D.toString());
    }
}
