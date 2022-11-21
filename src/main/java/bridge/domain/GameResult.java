package bridge.domain;

import java.util.List;

public class GameResult {

    private final List<Cell> bridgeStatus;

    private final GameStatus status;

    private final int attemptCount;

    public GameResult(List<Cell> bridgeStatus, GameStatus status, int attemptCount) {
        this.bridgeStatus = bridgeStatus;
        this.status = status;
        this.attemptCount = attemptCount;
    }

    public List<Cell> getBridgeStatus() {
        return bridgeStatus;
    }

    public GameStatus getStatus() {
        return status;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
