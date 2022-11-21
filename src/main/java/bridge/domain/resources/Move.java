package bridge.domain.resources;

import bridge.domain.exception.InvalidMoveException;

public class Move {

    public static final String UP = "U";
    public static final String DOWN = "D";

    private final String move;

    private Move(final String move) {
        if (!isUpOrDown(move)) {
            throw new InvalidMoveException();
        }

        this.move = move;
    }

    private boolean isUpOrDown(String move) {
        return move.equals(UP) || move.equals(DOWN);
    }

    public static Move from(final String move) {  // 정적 팩토리 메소드
        return new Move(move);
    }

    public String getMove() {
        return move;
    }

}
