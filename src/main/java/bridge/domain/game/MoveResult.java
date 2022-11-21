package bridge.domain.game;

import bridge.domain.Move;

public class MoveResult {

    private final Move move;
    private final boolean success;

    public MoveResult(String move, boolean success) {
        this.move = Move.from(move);
        this.success = success;
    }

    public Move getMove() {
        return move;
    }

    public boolean isSuccess() {
        return success;
    }
}
