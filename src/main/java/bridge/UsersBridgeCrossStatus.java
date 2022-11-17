package bridge;

import java.util.List;

public class UsersBridgeCrossStatus {
    private final List<List<String>> currentBridge;

    public UsersBridgeCrossStatus(List<List<String>> currentBridge) {
        this.currentBridge = currentBridge;
    }

    public List<List<String>> getCurrentBridge() {
        return currentBridge;
    }
}
