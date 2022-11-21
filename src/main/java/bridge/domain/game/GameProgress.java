package bridge.domain.game;

import bridge.domain.bridge.Move;

public class GameProgress {
    private final Move move;
    private final boolean success;

    public GameProgress(String moving, boolean success) {
        this.move = Move.from(moving);
        this.success = success;
    }

    public Move getMove() {
        return move;
    }

    public boolean isSuccess() {
        return success;
    }
}
