package bridge;

import bridge.domain.PlayResult;

public class GameResult {

    private final String direction;

    private final PlayResult playResult;

    public GameResult(final String direction, final PlayResult playResult) {
        this.direction = direction;
        this.playResult = playResult;
    }

    public String getDirection() {
        return direction;
    }

    public boolean isPass() {
        return playResult.isPass();
    }

    public boolean isFail() {
        return playResult.isFail();
    }
}
