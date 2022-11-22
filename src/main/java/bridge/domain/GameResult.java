package bridge.domain;

public class GameResult {

    private final Direction direction;

    private final PlayResult playResult;

    public GameResult(final Direction direction, final PlayResult playResult) {
        this.direction = direction;
        this.playResult = playResult;
    }

    public boolean isPass() {
        return playResult.isPass();
    }

    public boolean isFail() {
        return playResult.isFail();
    }

    public boolean isPlayerMoved(final Direction direction) {
        return this.direction == direction;
    }
}
