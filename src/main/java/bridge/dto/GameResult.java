package bridge.dto;

public class GameResult {

    private int tryCount;
    private MoveResult moveResult;

    public boolean isGameClear() {
        return moveResult.isSuccess();
    }

    public int getTryCount() {
        return tryCount;
    }

    public MoveResult getMoveResult() {
        return moveResult;
    }

    public GameResult(int tryCount, MoveResult moveResult) {
        this.tryCount = tryCount;
        this.moveResult = moveResult;
    }
}
