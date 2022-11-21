package bridge.domain;

public class BridgeGame {
    public Bridge bridge;
    public gameStatus currentStatus;
    public int attemptCount = 0;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.currentStatus = gameStatus.CONTINUE;
        this.attemptCount++;
    }

    public void move(String direction) {
        gameStatus moveResult = bridge.updateUserRoute(direction);
        this.currentStatus = moveResult;
    }

    public void retry() {
        attemptCount++;
        bridge.initializeUserRoute();
        currentStatus = gameStatus.CONTINUE;
    }
}
