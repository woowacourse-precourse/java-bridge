package bridge.data;

import bridge.constant.Move;

public class MoveResult {
    private final Move correctMove;
    private final boolean isUserMoveCorrect;

    public MoveResult(Move correctMove, boolean isUserMoveCorrect) {
        this.correctMove = correctMove;
        this.isUserMoveCorrect = isUserMoveCorrect;
    }

    public Move getCorrectMove() {
        return correctMove;
    }

    public boolean isUserMoveCorrect() {
        return isUserMoveCorrect;
    }
}
