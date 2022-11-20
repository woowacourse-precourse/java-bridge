package bridge.domain;

public class User {
    private int retryCount = 1;
    private final Bridge bridge;

    public User() {
        this.bridge = new Bridge();
    }

    public void addUpperBridge(String resultBlock) {
        bridge.addupperBridge(resultBlock);
        bridge.addLowerBridge("");
    }

    public void addLowerBridge(String resultBlock) {
        bridge.addupperBridge("");
        bridge.addLowerBridge(resultBlock);
    }
    public void plusRetryCount () {
        retryCount++;
    }

    public int getRetryCount() {
        return retryCount;
    }

    @Override
    public String toString() {
        return bridge.toString();
    }
}
