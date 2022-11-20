package bridge.domain;

public class User {
    private int retryCount;
    private final Bridge bridge;
    private boolean isRestartGame = false;

    public User(int retryCount) {
        this.retryCount = retryCount;
        this.bridge = new Bridge();
    }

    public boolean isRestartGame() {
        return isRestartGame;
    }

    public void changeisRestartGame() {
        isRestartGame = true;
    }

    public void addUpperBridge(String resultBlock) {
        bridge.addupperBridge(resultBlock);
    }

    public void addLowerBridge(String resultBlock) {
        bridge.addLowerBridge(resultBlock);
    }
    public void plusRetryCount () {
        this.retryCount++;
    }

    public int getRetryCount() {
        return retryCount;
    }

    @Override
    public String toString() {
        return bridge.toString();
    }
}
