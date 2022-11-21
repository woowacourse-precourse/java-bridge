package bridge.Game;

public class BridgeGame {

    private Bridge bridge;

    public void start() {
        this.bridge = new Bridge();
        move();
    }

    private void move() {
        boolean movable = bridge.isNotArrived();
        while (movable) {
            if (!bridge.passBridge()) {
                movable = retry();
                continue;
            }
            movable = bridge.isNotArrived();
        }
        endGame();
    }

    private boolean retry() {
        return bridge.retryPassBridge();
    }

    private void endGame() {
        bridge.showResult();
    }
}
