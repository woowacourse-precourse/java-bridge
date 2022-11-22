package bridge.domain;

public class GameResult {

    private final Direction direction;

    private final CompareResult compareResult;

    public GameResult(final Direction direction, final CompareResult compareResult) {
        this.direction = direction;
        this.compareResult = compareResult;
    }

    public boolean isPass() {
        return compareResult.isPass();
    }

    public boolean isFail() {
        return compareResult.isFail();
    }

    public boolean isPlayerMoved(final Direction direction) {
        return this.direction == direction;
    }
}
