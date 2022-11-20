package bridge.Database;

import java.util.List;

public class BridgeData {

    private List<String> bridge;
    private List<String> bridgeDesignByUser;
    private int totalAttempt;

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public void setBridgeDesignByUser(String bridgeDesignByUser) {
        this.bridgeDesignByUser.add(bridgeDesignByUser);
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public List<String> getBridgeDesignByUser() {
        return this.bridgeDesignByUser;
    }
    public int getTotalAttempt() {
        return this.totalAttempt;
    }

    public void increaseAttempts() {
        this.totalAttempt += 1;
    }

    public void setTotalAttempt() {
        this.totalAttempt = 0;
    }
}
