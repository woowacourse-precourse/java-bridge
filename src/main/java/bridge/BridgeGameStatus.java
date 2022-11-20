package bridge;

public class BridgeGameStatus {
    private boolean isRunning;

    public BridgeGameStatus(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void changeToGameOver() {
        this.isRunning = !isRunning;
    }
}
