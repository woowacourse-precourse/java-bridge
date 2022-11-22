package bridge.Database;

import java.util.ArrayList;
import java.util.List;

public class BridgeData {

    private List<String> bridge;
    private List<String> bridgeDesignByUser = new ArrayList<>();
    private int totalAttempt;

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return List.copyOf(this.bridge);
    }

    public List<String> getBridgeDesignByUser() {
        return List.copyOf(this.bridgeDesignByUser);
    }

    public int getTotalAttempt() {
        return this.totalAttempt;
    }

    public void increaseAttempts() {
        this.totalAttempt += 1;
    }

    public void initializeTotalAttempt() {
        this.totalAttempt = 1;
    }

    public void initializeBridgeDesignByUser() {
        this.bridgeDesignByUser = new ArrayList<>();
    }

    public void addBridgeDesignByUser(String nextStep) {
        this.bridgeDesignByUser.add(nextStep);
    }

    public void markFailedPointOnBridgeDesignByUser(int indexOfFailedPoint) {
        this.bridgeDesignByUser.set(indexOfFailedPoint, "X");
    }
}
