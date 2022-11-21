package bridge.domain;

public class BridgeGame {
    public Bridge bridge;
    public gameStatus currentStatus;
    public int attemptCount = 0;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.currentStatus = gameStatus.CONTINUE;
    }

    public void move(String direction) {
        gameStatus moveResult = bridge.updateUserRoute(direction);
        System.out.println(moveResult);
        this.currentStatus = moveResult;
    }

    public void retry() {
        attemptCount++;
        this.currentStatus = gameStatus.CONTINUE;
    }
}
