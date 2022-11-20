package bridge.domain;

public class User {
    private int retryCount;
    private final Bridge bridge;

    public User() {
        this.retryCount = 1;
        this.bridge = new Bridge();
    }

    public void addUpperBridge(String resultBlock) {
        bridge.addupperBridge(resultBlock);
        bridge.addLowerBridge(" ");
    }

    public void addLowerBridge(String resultBlock) {
        bridge.addupperBridge(" ");
        bridge.addLowerBridge(resultBlock);
    }
    public void plusRetryCount () {
        retryCount++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String stringBridge = bridge.toString()
                .replace(",", " | ")
                .replace("[", "[ ")
                .replace("]", " ]");
        sb.append(stringBridge).append("\n");
        return sb.toString();
    }
}
