package bridge.domain.resources;

import bridge.constant.Constant;
import bridge.domain.exception.InvalidMoveException;

public class Move {

    private final String move;

    private Move(final String move) {
        if (!isUpOrDown(move)) {
            throw new InvalidMoveException();
        }
        this.move = move;
    }

    private boolean isUpOrDown(final String move) {
        return move.equals(Constant.UP.getValue()) || move.equals(Constant.DOWN.getValue());
    }

    public static Move from(final String move) {  // 정적 팩토리 메소드
        return new Move(move);
    }

    public String getMove() {
        return move;
    }

}
