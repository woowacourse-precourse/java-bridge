package bridge.domain;

public class User {
    private int retryCount;
    private final Bridge bridge;
    private boolean restartFlag = false;

    public User(int retryCount) {
        this.retryCount = retryCount;
        this.bridge = new Bridge();
    }

    public boolean isRestartFlag() {
        return restartFlag;
    }

    public void setRestartGame() {
        restartFlag = true;
    }

    public void turnOffFlag() {
        restartFlag = false;
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