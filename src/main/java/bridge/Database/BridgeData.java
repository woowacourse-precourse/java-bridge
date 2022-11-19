package bridge.Database;

import java.util.List;

public class BridgeData {

    private List<String> bridge;
    private List<String> bridgeDesignByUser;
    private int totalAttempt;

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public void setBridgeDesignByUser(List<String> bridgeDesignByUser) {
        this.bridgeDesignByUser = bridgeDesignByUser;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public List<String> getBridgeDesignByUser() {
        return this.bridgeDesignByUser;
    }

    public void increaseAttempts() {
        this.totalAttempt += 1;
    }

    public BridgeData() {
        this.totalAttempt = 0;
    }
}
