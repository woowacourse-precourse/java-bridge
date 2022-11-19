package bridge.Database;

import java.util.List;

public class BridgeData {

    private List<String> bridge;
    private List<String> bridgeLayOutByUser;
    private int totalAttempt;

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public void setBridgeLayOutByUser(List<String> bridgeLayOutByUser) {
        this.bridgeLayOutByUser = bridgeLayOutByUser;
    }

    public List<String> getBridge() {
        return this.bridge;
    }
}
