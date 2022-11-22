package bridge.data;

import bridge.constant.GameResult;

import java.util.List;

public class FinalResult {
    private final GameResult gameResult;
    private final int numAttempts;
    private final List<MoveResult> moveResults;

    public FinalResult(GameResult gameResult, int numAttempts, List<MoveResult> moveResults) {
        this.gameResult = gameResult;
        this.numAttempts = numAttempts;
        this.moveResults = moveResults;
    }

    public GameResult getGameResult() {
        return this.gameResult;
    }

    public int getNumAttempts() {
        return this.numAttempts;
    }

    public List<MoveResult> getMoveResults() {
        return this.moveResults;
    }
}
