package bridge.domain;

public class BridgeGame {
    public Bridge bridge;
    public GameStatus currentStatus;
    public int attemptCount = 0;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.currentStatus = GameStatus.CONTINUE;
        this.attemptCount++;
    }

    public void move(String direction) {
        GameStatus moveResult = bridge.updateUserRoute(direction);
        this.currentStatus = moveResult;
    }

    public void retry() {
        attemptCount++;
        bridge.initializeUserRoute();
        currentStatus = GameStatus.CONTINUE;
    }
}
